package com.task.tracker.controller;

import com.task.tracker.controller.validator.EmailValidator;
import com.task.tracker.dao.DaoException;
import com.task.tracker.dao.UserDao;
import com.task.tracker.model.User;
import com.task.tracker.model.VerificationToken;
import com.task.tracker.service.EmailService;
import com.task.tracker.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.Locale;
import java.util.UUID;

@Controller
public class LoginController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private IUserService userService;

    @Autowired
    public JavaMailSender emailSender;

    @Autowired
    private EmailService emailService;

    @RequestMapping(value = { "/"}, method = RequestMethod.GET)
    public ModelAndView welcomePage() {
        ModelAndView model = new ModelAndView();
//        model.setViewName("loginPage");
        model.setViewName("hello");
        return model;
    }


    @RequestMapping(value = {"/registUser"}, method = RequestMethod.GET)
    public String registr(Model model){
        model.addAttribute("user", new User());
        return "views/registrUser";
    }

    @RequestMapping(value = {"/userAdd"}, method = RequestMethod.POST)
    public String userAdd ( HttpServletRequest request, @ModelAttribute("user") User user, RedirectAttributes redirectAttributes) throws DaoException {

        EmailValidator emailValidator = new EmailValidator();
        if(emailValidator.validate(user.getEmail()) == false){
            redirectAttributes.addAttribute("errore", true);
         return "redirect:/registUser";
        }
        this.userDao.add(user);

        String appUrl =
                "http://" + request.getServerName() +
                        ":" + request.getServerPort() +
                        request.getContextPath();
//
//        SimpleMailMessage email =
//                constructResendVerificationTokenEmail(appUrl, request.getLocale(), newToken, user);
//        emailSender.send(email);

//        emailService.sendSimpleMessage(user.getEmail(),appUrl,"привет ");
        final String token = UUID.randomUUID().toString();
        userService.createVerificationTokenForUser(user, token);

        final SimpleMailMessage email = constructEmailMessage(appUrl, user, token);
        emailSender.send(email);

        return "redirect:/";
    }


    @RequestMapping(value = "/registrationConfirm", method = RequestMethod.GET)
    public String confirmRegistration(
            Locale locale, Model model, @RequestParam("token") String token) throws DaoException {
        VerificationToken verificationToken = userService.getVerificationToken(token);
        if (verificationToken == null) {
            String message = "Невалидный токен";
            model.addAttribute("message", message);
            return "redirect:/badUser.html?lang=" + locale.getLanguage();
        }

        User user = verificationToken.getUser();
        Calendar cal = Calendar.getInstance();
        if ((verificationToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
            model.addAttribute("message", "Expired");
            model.addAttribute("expired", true);
            model.addAttribute("token", token);
            return "redirect:/badUser.html?lang=" + locale.getLanguage();
        }

        user.setEnabled(true);
        userDao.update(user);
        model.addAttribute("message", "Подтвержден");
        return "redirect:/managerPage";
    }


    private final SimpleMailMessage constructEmailMessage(String contextPath, final User user, final String token) {
        final String recipientAddress = user.getEmail();
        final String subject = "Registration Confirmation";
        final String confirmationUrl = contextPath + "/registrationConfirm?token=" + token;
        final String message = "Подтвердите";
        final SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText(message + " \r\n" + confirmationUrl);
//        email.setFrom(env.getProperty("support.email"));
        return email;
    }

    private SimpleMailMessage constructResendVerificationTokenEmail
            (String contextPath, Locale locale, VerificationToken newToken, User user) {
        String confirmationUrl =
                contextPath + "/registrationConfirm?token=" + newToken.getToken();
        String message = "Отправить повторно токен";
        SimpleMailMessage email = new SimpleMailMessage();
        email.setSubject("Resend Registration Token");
        email.setText(message + " rn" + confirmationUrl);
//        email.setFrom(env.getProperty("support.email"));
        email.setTo(user.getEmail());
        return email;
    }



    @RequestMapping(value = {"/developerPage"}, method = RequestMethod.GET)
    public ModelAndView developerPage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("views/developer/developerPage");
        return model;
    }


    @RequestMapping(value = {"/managerPage"}, method = RequestMethod.GET)
    public ModelAndView managerPage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("views/manager/managerPage");
        return model;
    }


    @RequestMapping(value="/logoutNew", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
//        return "redirect:/login?logout";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
    }

}