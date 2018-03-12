package com.task.tracker.controller;

import com.task.tracker.dao.DaoException;
import com.task.tracker.dao.ProjectDao;
import com.task.tracker.dao.TaskDao;
import com.task.tracker.dao.UserDao;
import com.task.tracker.model.Project;
import com.task.tracker.model.Task;
import com.task.tracker.model.User;
import com.task.tracker.service.EmailService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class ManagerController {


    @Autowired
    private ProjectDao projectDao;

    @Autowired
    private TaskDao taskDao;

    @Autowired
    private UserDao userDao;

    //---------------- ProjectController
    //read
    @RequestMapping(value = {"manager/projectPage"})
    public String projectPage(Model model, Principal principal) throws DaoException {
        model.addAttribute("projectList", this.projectDao.getAll());

        return "views/manager/project/managerProjectPage";
    }

    //Create
    @RequestMapping(value = {"/manager/projectNew"})
    public String projectNew(Model model) throws DaoException {
        model.addAttribute("project", new Project());
        return "views/manager/project/managerProjectNew";
    }

    @RequestMapping(value = {"/manager/projectCreate"})
    public String projectCreate(@ModelAttribute("project") Project project) throws DaoException {
        this.projectDao.add(project);
        return "redirect:/manager/projectPage";
    }


    //readById
    @RequestMapping(value = {"manager/projectGetBy/{id}"})
    public String projectGetById(@PathVariable("id") Long id, Model model) throws DaoException {
        Project project = this.projectDao.getById(id);
        model.addAttribute("projectById", project);
        List<Task> taskList = taskDao.getAll();
        model.addAttribute("taskList", taskList);
        return "views/manager/project/managerProjectGetById";
    }


    //update

    //delete
    @RequestMapping(value = {"/manager/projectDelete{id}"})
    public String projectDeleteById(@PathVariable("id") Long id) throws DaoException {
        Project project = new Project();
        project.setId(id);
        this.projectDao.remove(project);
        return "redirect:/manager/projectPage";
    }


    //----------------TaskController

    //read
    @RequestMapping(value = {"manager/taskPage"})
    public String taskPage(Model model) throws DaoException {
        model.addAttribute("taskList", this.taskDao.getAll());
        return "views/manager/task/managerTaskPage";
    }

    //readById


    //create
    @RequestMapping(value = {"manager/taskNew/{id}"})
    public String taskNew(@PathVariable("id") Long id, Model model) throws DaoException {
        model.addAttribute("task", new Task());
        model.addAttribute("projectTask", this.projectDao.getById(id));
        return "views/manager/task/managerTaskNew";
    }

    @RequestMapping(value = {"manager/taskCreate/{id}"})
    public String taskCreate(@PathVariable("id") Long id, @ModelAttribute("task") Task task) throws DaoException {
        Project project = projectDao.getById(id);
        task.setProject(project);
        this.taskDao.add(task);
        return "redirect:/manager/taskPage";
    }

    //update

    //delete
    @RequestMapping(value = {"manager/taskDelete{id}"})
    public String taskDeleteById(@PathVariable("id") Long id) throws DaoException {
        Task task = new Task();
        task.setId(id);
        this.taskDao.remove(task);
        return "redirect:/manager/taskPage";
    }


    //----------------UserController
    //read
    @RequestMapping(value = {"manager/developerPage"})
    public String developerPage(Model model) throws DaoException, IOException {
//        ObjectMapper objectMapper = new ObjectMapper();

        List<User> developers = this.userDao.getDeveloper();
        model.addAttribute("developers", developers);

//        model.addAttribute("developers", objectMapper.writeValueAsString(developers));
        return "views/manager/user/managerDeveloperPage";
    }

    @RequestMapping(value = {"manager/developerAddProject/{id}"})
    public String developerAddProject(@PathVariable("id") Long id, Model model) throws DaoException {
        List<User> developers = this.userDao.getDeveloper();
        model.addAttribute("developers", developers);
        model.addAttribute("project", projectDao.getById(id));
        return "views/manager/user/managerDeveloperAddProject";
    }


    @RequestMapping(value = {"manager/developerUpProject/{id}/{idUser}"})
    public String developerUpProject(@PathVariable("id") Long id, @PathVariable() Long idUser, @ModelAttribute("developer") User user) throws DaoException {
        Project project = projectDao.getById(id);
        user = userDao.getById(idUser);
        Set<User> userSet = project.getUsers();
        userSet.add(user);
        project.setUsers(userSet);
        this.projectDao.update(project);
        return "redirect:/manager/projectPage";
    }


    @RequestMapping(value = {"manager/taskAddDeveloper/{id}/{id}"})
    public String taskAddDeveloper(@PathVariable("id") Long taskId, @PathVariable("id") Long projectId, Model model) throws DaoException {
        Task task =  this.taskDao.getById(taskId);
        model.addAttribute("task",task);
        Project project = this.projectDao.getById(projectId);
        Set<User> userSet = project.getUsers();
        model.addAttribute("userSetProject", userSet);
        return "views/manager/task/managerTaskAddDeveloper";
    }

    @RequestMapping(value = {"/manager/developer{id}UpTask{task}"})
    public String developerUpTask(@PathVariable("id") Long developerId, @PathVariable("task") Long taskId, @ModelAttribute("developer") User user) throws DaoException {
        user = this.userDao.getById(developerId);
        Task task = this.taskDao.getById(taskId);
        Set<Task> taskSet = user.getTasks();
        taskSet.add(task);
        this.userDao.update(user);
        task.setUser(user);
        this.taskDao.update(task);
        return "redirect:/manager/developerPage";
    }
}
