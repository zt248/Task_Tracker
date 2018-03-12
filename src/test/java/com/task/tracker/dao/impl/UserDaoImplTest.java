package com.task.tracker.dao.impl;


import com.task.tracker.config.ApplicationConfig;
import com.task.tracker.dao.DaoException;
import com.task.tracker.dao.UserDao;
import com.task.tracker.model.Comment;
import com.task.tracker.model.Project;
import com.task.tracker.model.Task;
import com.task.tracker.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
public class UserDaoImplTest {


    @Autowired
    private UserDao userDao;


    @Test
    public void add() throws DaoException {

        User user = new User();
        user.setId(null);
        user.setLastName("TestLastName");
        user.setFirstName("TestFirstName");
        user.setPassword("testPassword");
        user.setEmail("testEmail");
//        user.setRoles("testRoles");

        Project project = new Project();
        project.setId(null);
        project.setName("testName");
        Set<Project> projectSet = new HashSet<>();
        projectSet.add(project);
        user.setProjects(projectSet);

        Task task = new Task();
        task.setId(null);
        task.setNameTask("testName");
        task.setDescription("TestDescription");
        Set<Task> taskSet = new HashSet<>();
        taskSet.add(task);
        user.setTasks(taskSet);

        Comment comment = new Comment();
        comment.setId(null);
        comment.setTextComment("testTestComment");
        Set<Comment> commentSet = new HashSet<>();
        commentSet.add(comment);
        user.setComments(commentSet);

        userDao.add(user);
        Assert.assertEquals(userDao.getById(user.getId()).getId(),user.getId());
        Assert.assertEquals(userDao.getById(user.getId()).getLastName(),user.getLastName());
        Assert.assertEquals(userDao.getById(user.getId()).getFirstName(),user.getFirstName());
        Assert.assertEquals(userDao.getById(user.getId()).getEmail(),user.getEmail());
        Assert.assertEquals(userDao.getById(user.getId()).getPassword(),user.getPassword());
//        Assert.assertEquals(userDao.getById(user.getId()).getRoles(),user.getRoles());
        Assert.assertEquals(userDao.getById(user.getId()).getProjects().iterator().next().getId(),project.getId());
        Assert.assertEquals(userDao.getById(user.getId()).getComments().iterator().next().getId(),comment.getId());
        Assert.assertEquals(userDao.getById(user.getId()).getTasks().iterator().next().getId(),task.getId());
        userDao.remove(user);
    }

    @Test
    public void getAll() throws DaoException {

        User user = new User();
        user.setId(null);
        user.setLastName("TestLastName");
        user.setFirstName("TestFirstName");
        user.setPassword("testPassword");
        user.setEmail("testEmail");
//        user.setRoles("testRoles");


        Project project = new Project();
        project.setName("testName");
        Set<Project> projectSet = new HashSet<>();
        projectSet.add(project);
        user.setProjects(projectSet);

        Task task = new Task();
        task.setNameTask("testName");
        task.setDescription("TestDescription");
        Set<Task> taskSet = new HashSet<>();
        taskSet.add(task);
        user.setTasks(taskSet);


        Comment comment = new Comment();
        comment.setTextComment("testTestComment");
        Set<Comment> commentSet = new HashSet<>();
        commentSet.add(comment);
        user.setComments(commentSet);


        userDao.add(user);

        List<User> list = userDao.getAll();
        Assert.assertNotNull(list);
        Assert.assertTrue(list.size() > 0);
        userDao.remove(user);
    }

    @Test
    public void getById() throws DaoException {
        User user = new User();
        user.setId(null);
        user.setLastName("TestLastName");
        user.setFirstName("TestFirstName");
        user.setPassword("testPassword");
        user.setEmail("testEmail");
//        user.setRoles("Roles");

        Project project = new Project();
        project.setId(null);
        project.setName("testName");
        Set<Project> projectSet = new HashSet<>();
        projectSet.add(project);
        user.setProjects(projectSet);

        Task task = new Task();
        task.setId(null);
        task.setNameTask("testName");
        task.setDescription("TestDescription");
        Set<Task> taskSet = new HashSet<>();
        taskSet.add(task);
        user.setTasks(taskSet);

        Comment comment = new Comment();
        comment.setId(null);
        comment.setTextComment("testTestComment");
        Set<Comment> commentSet = new HashSet<>();
        commentSet.add(comment);
        user.setComments(commentSet);

        userDao.add(user);
        Assert.assertEquals(userDao.getById(user.getId()).getId(),user.getId());
        Assert.assertEquals(userDao.getById(user.getId()).getLastName(),user.getLastName());
        Assert.assertEquals(userDao.getById(user.getId()).getFirstName(),user.getFirstName());
        Assert.assertEquals(userDao.getById(user.getId()).getEmail(),user.getEmail());
        Assert.assertEquals(userDao.getById(user.getId()).getPassword(),user.getPassword());
//        Assert.assertEquals(userDao.getById(user.getId()).getRoles(),user.getRoles());
        Assert.assertEquals(userDao.getById(user.getId()).getProjects().iterator().next().getId(),project.getId());
        Assert.assertEquals(userDao.getById(user.getId()).getComments().iterator().next().getId(),comment.getId());
        Assert.assertEquals(userDao.getById(user.getId()).getTasks().iterator().next().getId(),task.getId());
        userDao.remove(user);
    }

    @Test
    public void update() throws DaoException {
        User user = new User();
        user.setId(null);
        user.setLastName("TestLastName");
        user.setFirstName("TestFirstName");
        user.setPassword("testPassword");
        user.setEmail("testEmail");
//        user.setRoles("testRoles");

        Project project = new Project();
        project.setId(null);
        project.setName("testName");
        Set<Project> projectSet = new HashSet<>();
        projectSet.add(project);
        user.setProjects(projectSet);

        Task task = new Task();
        task.setId(null);
        task.setNameTask("testName");
        task.setDescription("TestDescription");
        Set<Task> taskSet = new HashSet<>();
        taskSet.add(task);
        user.setTasks(taskSet);

        Comment comment = new Comment();
        comment.setId(null);
        comment.setTextComment("testTestComment");
        Set<Comment> commentSet = new HashSet<>();
        commentSet.add(comment);
        user.setComments(commentSet);

        userDao.add(user);
        Assert.assertEquals(userDao.getById(user.getId()).getId(),user.getId());
        Assert.assertEquals(userDao.getById(user.getId()).getLastName(),user.getLastName());
        Assert.assertEquals(userDao.getById(user.getId()).getFirstName(),user.getFirstName());
        Assert.assertEquals(userDao.getById(user.getId()).getEmail(),user.getEmail());
        Assert.assertEquals(userDao.getById(user.getId()).getPassword(),user.getPassword());
//        Assert.assertEquals(userDao.getById(user.getId()).getRoles(),user.getRoles());
        Assert.assertEquals(userDao.getById(user.getId()).getProjects().iterator().next().getId(),project.getId());
        Assert.assertEquals(userDao.getById(user.getId()).getComments().iterator().next().getId(),comment.getId());
        Assert.assertEquals(userDao.getById(user.getId()).getTasks().iterator().next().getId(),task.getId());

        user.setLastName("UpdateTestLastName");
        user.setFirstName("UpdateTestLastNameTestFirstName");
        user.setPassword("UpdateTestLastNametestPassword");
        user.setEmail("UpdateTestLastNametestEmail");
//        user.setRoles("UpdateTestLastNametestRoles");

        project.setName("UpdateTestLastNametestName");
        projectSet.add(project);
        user.setProjects(projectSet);

        task.setNameTask("UpdateTestLastNametestName");
        task.setDescription("UpdateTestLastNameTestDescription");
        taskSet.add(task);
        user.setTasks(taskSet);

        comment.setTextComment("UpdateTestLastNametestTestComment");
        commentSet.add(comment);
        user.setComments(commentSet);
        userDao.update(user);

        Assert.assertEquals(userDao.getById(user.getId()).getId(),user.getId());
        Assert.assertEquals(userDao.getById(user.getId()).getLastName(),user.getLastName());
        Assert.assertEquals(userDao.getById(user.getId()).getFirstName(),user.getFirstName());
        Assert.assertEquals(userDao.getById(user.getId()).getEmail(),user.getEmail());
        Assert.assertEquals(userDao.getById(user.getId()).getPassword(),user.getPassword());
//        Assert.assertEquals(userDao.getById(user.getId()).getRoles(),user.getRoles());
        Assert.assertEquals(userDao.getById(user.getId()).getProjects().iterator().next().getId(),project.getId());
        Assert.assertEquals(userDao.getById(user.getId()).getComments().iterator().next().getId(),comment.getId());
        Assert.assertEquals(userDao.getById(user.getId()).getTasks().iterator().next().getId(),task.getId());

        userDao.remove(user);
    }

    @Test
    public void remove() throws DaoException {

        User user = new User();
        user.setId(null);
        user.setLastName("TestLastName");
        user.setFirstName("TestFirstName");
        user.setPassword("testPassword");
        user.setEmail("testEmail");
//        user.setRoles("testRoles");


        Project project = new Project();
        project.setName("testName");
        Set<Project> projectSet = new HashSet<>();
        projectSet.add(project);
        user.setProjects(projectSet);

        Task task = new Task();
        task.setNameTask("testName");
        task.setDescription("TestDescription");
        Set<Task> taskSet = new HashSet<>();
        taskSet.add(task);
        user.setTasks(taskSet);


        Comment comment = new Comment();
        comment.setTextComment("testTestComment");
        Set<Comment> commentSet = new HashSet<>();
        commentSet.add(comment);
        user.setComments(commentSet);


        userDao.add(user);

        Assert.assertNotNull(userDao.getById(user.getId()).getId());
        userDao.remove(user);
        try {
            Assert.assertNull(userDao.getById(user.getId()).getId());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

}
