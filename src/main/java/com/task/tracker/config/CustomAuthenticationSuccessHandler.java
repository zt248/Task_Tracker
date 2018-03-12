package com.task.tracker.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomAuthenticationSuccessHandler  implements AuthenticationSuccessHandler {


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        //set our response to OK status
        response.setStatus(HttpServletResponse.SC_OK);

        boolean manager = false;
        boolean developer = false;


        for (GrantedAuthority auth : authentication.getAuthorities()) {
            if ("ROLE_MANAGER".equals(auth.getAuthority())){
                manager = true;
            } else if ("ROLE_DEVELOPER".equals(auth.getAuthority())){
                developer = true;
            }
        }

        if(manager){
            response.sendRedirect("/managerPage");
        }else if (developer){
            response.sendRedirect("/developerPage");
        }
    }
}