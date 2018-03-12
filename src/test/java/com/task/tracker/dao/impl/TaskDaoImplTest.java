package com.task.tracker.dao.impl;


import com.task.tracker.config.ApplicationConfig;
import com.task.tracker.dao.DaoException;
import com.task.tracker.dao.TaskDao;
import com.task.tracker.model.Comment;
import com.task.tracker.model.Project;
import com.task.tracker.model.Task;
import com.task.tracker.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class TaskDaoImplTest {


    @Autowired
    private TaskDao taskDao;

    @Test
    public void add() throws DaoException {


        Task task = new Task();
        task.setId(null);
        task.setNameTask("testName");
        task.setDescription("TestDescription");

        Comment comment = new Comment();
        comment.setId(null);
        comment.setTextComment("testTestComment");
        Set<Comment> commentSet = new HashSet<>();
        commentSet.add(comment);
        task.setComments(commentSet);

        Project project = new Project();
        project.setId(null);
        project.setName("testName");
        task.setProject(project);

        User user = new User();
        user.setId(null);
        user.setLastName("TestLastName");
        user.setFirstName("TestFirstName");
        user.setPassword("testPassword");
        user.setEmail("testEmail");
//        user.setRoles("testRoles");
        task.setUser(user);
        taskDao.add(task);

        Assert.assertEquals(taskDao.getById(task.getId()).getId(),task.getId());
        Assert.assertEquals(taskDao.getById(task.getId()).getNameTask(),task.getNameTask());
        Assert.assertEquals(taskDao.getById(task.getId()).getDescription(),task.getDescription());
        Assert.assertEquals(taskDao.getById(task.getId()).getComments().iterator().next().getId(),comment.getId());
        Assert.assertEquals(taskDao.getById(task.getId()).getProject().getId(),project.getId());
        Assert.assertEquals(taskDao.getById(task.getId()).getUser().getId(),user.getId());

        taskDao.remove(task);

    }

    @Test
    public void getAll() throws DaoException {

        Task task = new Task();
        task.setNameTask("testName");
        task.setDescription("TestDescription");

        Comment comment = new Comment();
        comment.setTextComment("testTestComment");
        Set<Comment> commentSet = new HashSet<>();
        commentSet.add(comment);
        task.setComments(commentSet);

        Project project = new Project();
        project.setName("testName");
        task.setProject(project);

        User user = new User();
        user.setLastName("TestLastName");
        user.setFirstName("TestFirstName");
        user.setPassword("testPassword");
        user.setEmail("testEmail");
//        user.setRoles("testRoles");
        task.setUser(user);
        taskDao.add(task);


        List<Task> list = taskDao.getAll();
        Assert.assertNotNull(list);
        Assert.assertTrue(list.size() > 0);
        taskDao.remove(task);
    }

    @Test
    public void getById() throws DaoException {
        Task task = new Task();
        task.setId(null);
        task.setNameTask("testName");
        task.setDescription("TestDescription");

        Comment comment = new Comment();
        comment.setId(null);
        comment.setTextComment("testTestComment");
        Set<Comment> commentSet = new HashSet<>();
        commentSet.add(comment);
        task.setComments(commentSet);

        Project project = new Project();
        project.setId(null);
        project.setName("testName");
        task.setProject(project);

        User user = new User();
        user.setId(null);
        user.setLastName("TestLastName");
        user.setFirstName("TestFirstName");
        user.setPassword("testPassword");
        user.setEmail("testEmail");
//        user.setRoles("Roles");
        task.setUser(user);
        taskDao.add(task);

        Assert.assertEquals(taskDao.getById(task.getId()).getId(),task.getId());
        Assert.assertEquals(taskDao.getById(task.getId()).getNameTask(),task.getNameTask());
        Assert.assertEquals(taskDao.getById(task.getId()).getDescription(),task.getDescription());
        Assert.assertEquals(taskDao.getById(task.getId()).getComments().iterator().next().getId(),comment.getId());
        Assert.assertEquals(taskDao.getById(task.getId()).getProject().getId(),project.getId());
        Assert.assertEquals(taskDao.getById(task.getId()).getUser().getId(),user.getId());
        taskDao.remove(task);
    }

    @Test
    public void update() throws DaoException {
        Task task = new Task();
        task.setId(null);
        task.setNameTask("testName");
        task.setDescription("TestDescription");

        Comment comment = new Comment();
        comment.setId(null);
        comment.setTextComment("testTestComment");
        Set<Comment> commentSet = new HashSet<>();
        commentSet.add(comment);
        task.setComments(commentSet);

        Project project = new Project();
        project.setId(null);
        project.setName("testName");
        task.setProject(project);

        User user = new User();
        user.setId(null);
        user.setLastName("TestLastName");
        user.setFirstName("TestFirstName");
        user.setPassword("testPassword");
        user.setEmail("testEmail");
//        user.setRoles("Roles");
        task.setUser(user);
        taskDao.add(task);

        Assert.assertEquals(taskDao.getById(task.getId()).getId(),task.getId());
        Assert.assertEquals(taskDao.getById(task.getId()).getNameTask(),task.getNameTask());
        Assert.assertEquals(taskDao.getById(task.getId()).getDescription(),task.getDescription());
        Assert.assertEquals(taskDao.getById(task.getId()).getComments().iterator().next().getId(),comment.getId());
        Assert.assertEquals(taskDao.getById(task.getId()).getProject().getId(),project.getId());
        Assert.assertEquals(taskDao.getById(task.getId()).getUser().getId(),user.getId());

        task.setNameTask("updatetestName");
        task.setDescription("updateTestDescription");

        comment.setTextComment("updatetestTestComment");
        commentSet.add(comment);
        task.setComments(commentSet);

        project.setName("updatetestName");
        task.setProject(project);

        user.setLastName("updateTestLastName");
        user.setFirstName("updateTestFirstName");
        user.setPassword("updatetestPassword");
        user.setEmail("updatetestEmail");
//        user.setRoles("updateRoles");
        task.setUser(user);
        taskDao.update(task);

        Assert.assertEquals(taskDao.getById(task.getId()).getId(),task.getId());
        Assert.assertEquals(taskDao.getById(task.getId()).getNameTask(),task.getNameTask());
        Assert.assertEquals(taskDao.getById(task.getId()).getDescription(),task.getDescription());
        Assert.assertEquals(taskDao.getById(task.getId()).getComments().iterator().next().getId(),comment.getId());
        Assert.assertEquals(taskDao.getById(task.getId()).getProject().getId(),project.getId());
        Assert.assertEquals(taskDao.getById(task.getId()).getUser().getId(),user.getId());

        taskDao.remove(task);
    }

    @Test
    public void remove() throws DaoException {
        Task task = new Task();
        task.setId(null);
        task.setNameTask("testName");
        task.setDescription("TestDescription");

        Comment comment = new Comment();
        comment.setId(null);
        comment.setTextComment("testTestComment");
        Set<Comment> commentSet = new HashSet<>();
        commentSet.add(comment);
        task.setComments(commentSet);

        Project project = new Project();
        project.setId(null);
        project.setName("testName");
        task.setProject(project);

        User user = new User();
        user.setId(null);
        user.setLastName("TestLastName");
        user.setFirstName("TestFirstName");
        user.setPassword("testPassword");
        user.setEmail("testEmail");
//        user.setRoles("Roles");
        task.setUser(user);
        taskDao.add(task);


        Assert.assertNotNull(taskDao.getById(task.getId()).getId());
        taskDao.remove(task);
        try {
            Assert.assertNull(taskDao.getById(task.getId()).getId());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

}
