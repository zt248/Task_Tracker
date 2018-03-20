package com.task.tracker.controller;

import com.task.tracker.dao.*;
import com.task.tracker.model.Comment;
import com.task.tracker.model.Project;
import com.task.tracker.model.Task;
import com.task.tracker.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @Autowired
    private CommentDao commentDao;


    @RequestMapping(value = {"developer/developerProjectGetBy/{id}"})
    public String projectGetById(@PathVariable("id") Long id, Model model) throws DaoException {
        Project project = this.projectDao.getById(id);
        model.addAttribute("projectById", project);
        List<Task> taskList = taskDao.getProjectTask(project.getId());
        model.addAttribute("taskList", taskList);
        return "views/developer/project/developerProjectGetById";
    }


    @RequestMapping(value = {"developer/taskNew/{id}"})
    public String taskNew(@PathVariable("id") Long id, Model model) throws DaoException {
        model.addAttribute("task", new Task());
        model.addAttribute("projectTask", this.projectDao.getById(id));
        return "views/developer/task/developerTaskNew";
    }

    @RequestMapping(value = {"developer/taskCreate/{id}"})
    public String taskCreate(@PathVariable("id") Long id, @ModelAttribute("task") Task task) throws DaoException {
        Project project = projectDao.getById(id);
        task.setProject(project);
        this.taskDao.add(task);
        return "redirect:/developer/developerProjectGetBy/" + id + "";
    }

    @RequestMapping(value = {"developer/developerGetMyTask"})
    public String developerGetMyTask(Model model, Principal principal) throws DaoException{
        List<User> userList = this.userDao.developerGetAllProject(principal.getName());
        model.addAttribute("userList", userList);
        return "views/developer/task/developerGetMyTask";
    }

    @RequestMapping(value = {"developer/TaskGetBy/{idTask}"})
    public String taskGetBy(@PathVariable("idTask") Long idTask, Model model) throws DaoException {
        Comment comment = new Comment();
        model.addAttribute("comment", comment);
        Task task = this.taskDao.getById(idTask);
        model.addAttribute("task", task);
        return "views/developer/task/developerTaskGetById";
    }

    @RequestMapping(value = {"developer/Task{idTask}CreateComment"})
    public String taskCreateComment(@PathVariable("idTask") Long idTask, Model model) throws DaoException {
        Task task  = this.taskDao.getById(idTask);
        model.addAttribute("task", task);
        Comment comment = new Comment();
        model.addAttribute("comment", comment);
        return "views/developer/comment/developerCreateComment";
    }

    @RequestMapping(value = {"developer/Task{idTask}AddComment"})
    public String taskAddComment(@PathVariable("idTask") Long idTask, @ModelAttribute("comment") Comment comment) throws DaoException {
        Task task = this.taskDao.getById(idTask);
        comment.setUser(task.getUser());
        comment.setTask(task);
        this.commentDao.add(comment);
        return "redirect:/developer/TaskGetBy/" + idTask + "";
    }

    @RequestMapping(value = {"developer/developerDeleteComment{idComment}/{idTask}"})
    public String developerDeleteComment(@PathVariable("idComment") Long idComment, @PathVariable("idTask") Long idTask) throws DaoException {
        Comment comment = this.commentDao.getById(idComment);
        this.commentDao.remove(comment);
        return "redirect:/developer/TaskGetBy/" + idTask + "";
    }

    @RequestMapping(value = {"developer/developerUpdateComment{idComment}Page/{idTask}"})
    public String developerUpdateCommentPage(@PathVariable("idComment") Long idComment,@PathVariable("idTask") Long idTask, Model model) throws DaoException{
        Comment comment = this.commentDao.getById(idComment);
        model.addAttribute("comment", comment);
        Long id = idTask;
        model.addAttribute("idTask",id);
        return "views/developer/comment/developerUpdateComment";
    }

    @RequestMapping(value = {"developer/developerUpdateComment{idTask}"}, method = RequestMethod.POST)
    public String developerUpdateComment(@ModelAttribute("comment") Comment comment,@PathVariable("idTask") Long idTask) throws DaoException{
        Task task = this.taskDao.getById(idTask);
        comment.setTask(task);
        comment.setUser(task.getUser());
        this.commentDao.update(comment);
        return "redirect:/developer/TaskGetBy/" + idTask + "";
    }

    @RequestMapping(value = {"developer/developerUpdateTask{idTask}Status"})
    public String developerUpdateTaskStatus(@PathVariable("idTask") Long idTask, Model model) throws DaoException{
        Task task = this.taskDao.getById(idTask);
        model.addAttribute("task", task);
        return "views/developer/task/developerUpdateTaskStatus";
    }

    @RequestMapping(value = {"developer/developerUpdateTaskStatus{idTask}"})
    public String developerUpdateTaskStatus(@ModelAttribute("task") Task task,@PathVariable("idTask") Long idTask) throws DaoException {
        Task task1 = this.taskDao.getById(idTask);
        task.setComments(task1.getComments());
        task.setUser(task1.getUser());
        this.taskDao.update(task);
        return "redirect:/developer/TaskGetBy/" + task.getId() + "";
    }

}
