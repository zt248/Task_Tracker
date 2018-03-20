package com.task.tracker.controller;

import com.task.tracker.dao.*;
import com.task.tracker.model.Comment;
import com.task.tracker.model.Project;
import com.task.tracker.model.Task;
import com.task.tracker.model.User;
import com.task.tracker.service.EmailService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private CommentDao commentDao;

    //---------------- ProjectController

    //read
//    @RequestMapping(value = {"manager/projectPage"})
//    public String projectPage(Model model, Principal principal) throws DaoException {
//        model.addAttribute("projectList", this.projectDao.getAll());
//        return "views/manager/project/managerProjectPage";
//    }

    //Create
    @RequestMapping(value = {"/manager/projectNew"})
    public String projectNew(Model model) throws DaoException {
        model.addAttribute("project", new Project());
        return "views/manager/project/managerProjectNew";
    }

    @RequestMapping(value = {"/manager/projectCreate"})
    public String projectCreate(@ModelAttribute("project") Project project) throws DaoException {
        this.projectDao.add(project);
        return "redirect:/managerPage";
    }


    //readById
    @RequestMapping(value = {"manager/projectGetBy/{id}"})
    public String projectGetById(@PathVariable("id") Long id, Model model) throws DaoException {
        Project project = this.projectDao.getById(id);
        model.addAttribute("projectById", project);
        List<Task> taskList = taskDao.getProjectTask(project.getId());
        model.addAttribute("taskList", taskList);
        return "views/manager/project/managerProjectGetById";
    }


    @RequestMapping(value = {"manager/TaskGetBy/{idTask}"})
    public String taskGetBy(@PathVariable("idTask") Long idTask, Model model) throws DaoException {
        Comment comment = new Comment();
        model.addAttribute("comment", comment);
        Task task = this.taskDao.getById(idTask);
        model.addAttribute("task", task);
        return "views/manager/task/managerTaskGetById";
    }

    @RequestMapping(value = {"manager/Task{idTask}CreateComment"})
    public String taskCreateComment(@PathVariable("idTask") Long idTask, Model model) throws DaoException {
        Task task  = this.taskDao.getById(idTask);
        model.addAttribute("task", task);
        Comment comment = new Comment();
        model.addAttribute("comment", comment);
        return "views/manager/comment/managerCreateComment";
    }

    @RequestMapping(value = {"manager/Task{idTask}AddComment"})
    public String taskAddComment(@PathVariable("idTask") Long idTask, @ModelAttribute("comment") Comment comment) throws DaoException {
        Task task = this.taskDao.getById(idTask);
        comment.setUser(task.getUser());
        comment.setTask(task);
        this.commentDao.add(comment);
        return "redirect:/manager/TaskGetBy/" + idTask + "";
    }


    @RequestMapping(value = {"/manager/projectDelete{id}"})
    public String projectDeleteById(@PathVariable("id") Long id) throws DaoException {
        Project project = projectDao.getById(id);
        this.projectDao.remove(project);
        return "redirect:/managerPage";
    }


    //----------------TaskController

    //read
    @RequestMapping(value = {"manager/taskPage"})
    public String taskPage(Model model) throws DaoException {
        model.addAttribute("taskList", this.taskDao.getAll());
        return "views/manager/task/managerTaskPage";
    }



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


    @RequestMapping(value = {"manager/taskDelete{id}"})
    public String taskDeleteById(@PathVariable("id") Long id) throws DaoException {
        Task task = this.taskDao.getById(id);
        this.taskDao.remove(task);
        return "redirect:/manager/taskPage";
    }


    //----------------UserController
    //read
    @RequestMapping(value = {"manager/developerPage"})
    public String developerPage(Model model) throws DaoException, IOException {
        List<User> developers = this.userDao.getDeveloper();
        model.addAttribute("developers", developers);
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


    @RequestMapping(value = {"manager/taskAddDeveloper/{taskId}/{projectId}"})
    public String taskAddDeveloper(@PathVariable("taskId") Long taskId, @PathVariable("projectId") Long projectId, Model model) throws DaoException {
        Task task = this.taskDao.getById(taskId);
        model.addAttribute("task", task);
        Project project = this.projectDao.getById(projectId);
        Set<User> userSet = project.getUsers();
        model.addAttribute("userSetProject", userSet);
        return "views/manager/task/managerTaskAddDeveloper";
    }

    @RequestMapping(value = {"/manager/developer{id}UpTask{task}"})
    public String developerUpTask(@PathVariable("id") Long developerId, @PathVariable("task") Long taskId, @ModelAttribute("developer") User user) throws DaoException {
        user = this.userDao.getById(developerId);
        Task task = this.taskDao.getById(taskId);
        task.setUser(user);
        Set<Task> taskSet = user.getTasks();
        taskSet.add(task);
        this.userDao.update(user);
//        task.setUser(user);
//        this.taskDao.update(task);
        return "redirect:/manager/developerPage";
    }


    @RequestMapping(value = {"manager/managerPoisk"})
    public String managerPoisk(Model model) throws DaoException{
        List<User> userList = this.userDao.getAll();
        model.addAttribute("userList", userList);
        return "views/manager/user/managerPoisk";
    }

    @RequestMapping(value = {"manager/poisk"})
    public String poisk(@RequestParam("last_name") String last_name, @RequestParam("first_name") String first_name, Model model) throws DaoException{
        List<User> userList = this.userDao.getDeveloperLastFist(last_name,first_name);
        model.addAttribute("userList",userList);
        return "views/manager/user/managerUserPoisk";
    }

    //----------------Comment

    @RequestMapping(value = {"manager/managerDeleteComment{idComment}/{idTask}"})
    public String managerDeleteTask(@PathVariable("idComment") Long idComment, @PathVariable("idTask") Long idTask) throws DaoException {
        Comment comment = this.commentDao.getById(idComment);
        this.commentDao.remove(comment);
        return "redirect:/manager/TaskGetBy/" + idTask + "";
    }

    @RequestMapping(value = {"manager/managerUpdateComment{idComment}Page/{idTask}"})
    public String managerUpdateCommentPage(@PathVariable("idComment") Long idComment,@PathVariable("idTask") Long idTask, Model model) throws DaoException{
        Comment comment = this.commentDao.getById(idComment);
        model.addAttribute("comment", comment);
        Long id = idTask;
        model.addAttribute("idTask",id);
        return "views/manager/comment/managerUpdateComment";
    }

    @RequestMapping(value = {"manager/managerUpdateComment{idTask}"}, method = RequestMethod.POST)
    public String managerUpdateComment(@ModelAttribute("comment") Comment comment,@PathVariable("idTask") Long idTask) throws DaoException{
        Task task = this.taskDao.getById(idTask);
        comment.setTask(task);
        comment.setUser(task.getUser());
        this.commentDao.update(comment);
        return "redirect:/manager/TaskGetBy/" + idTask + "";
    }

    @RequestMapping(value = {"manager/managerUpdateTask{idTask}Status"})
    public String managerUpdateTaskStatus(@PathVariable("idTask") Long idTask, Model model) throws DaoException{
        Task task = this.taskDao.getById(idTask);
        model.addAttribute("task", task);
        return "views/manager/task/managerUpdateTaskStatus";
    }

    @RequestMapping(value = {"manager/managerUpdateTaskStatus{idTask}"})
    public String managerUpdateTaskStatus(@ModelAttribute("task") Task task,@PathVariable("idTask") Long idTask) throws DaoException {
        Task task1 = this.taskDao.getById(idTask);
        task.setComments(task1.getComments());
        task.setUser(task1.getUser());
        this.taskDao.update(task);
        return "redirect:/manager/TaskGetBy/" + task.getId() + "";
    }
}
