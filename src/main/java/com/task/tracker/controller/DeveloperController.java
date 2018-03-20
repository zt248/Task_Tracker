package com.task.tracker.controller;

import com.task.tracker.dao.DaoException;
import com.task.tracker.dao.ProjectDao;
import com.task.tracker.dao.TaskDao;
import com.task.tracker.dao.UserDao;
import com.task.tracker.model.Project;
import com.task.tracker.model.Task;
import com.task.tracker.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class DeveloperController {


    @Autowired
    private UserDao userDao;

    @Autowired
    private ProjectDao projectDao;

    @Autowired
    private TaskDao taskDao;


    @RequestMapping(value = {"developer/developerGetAllProject"})
    public String developerGetAllProject(Model model, Principal principal) throws DaoException {
        List<User> userList = this.userDao.developerGetAllProject(principal.getName());
//        List<Project> userList = this.projectDao.getAllProject(principal.getName());
//        for (Project pr : userList){
//            System.out.println(pr);
//        }
        model.addAttribute("userList",userList);
//        model.addAttribute("project",userList);
        return "views/developer/project/developerProjectPage";
    }


    @RequestMapping(value = {"developerCreate"})
    public String developerCreate(){
        return "views/developer/developerCreate";
    }

    //readById
    @RequestMapping(value = {"developer/developerProjectGetBy/{id}"})
    public String projectGetById(@PathVariable("id") Long id, Model model) throws DaoException {
        Project project = this.projectDao.getById(id);
        model.addAttribute("projectById", project);
        List<Task> taskList = taskDao.getProjectTask(project.getId());
        model.addAttribute("taskList", taskList);
        return "views/developer/project/developerProjectGetById";
    }


}
