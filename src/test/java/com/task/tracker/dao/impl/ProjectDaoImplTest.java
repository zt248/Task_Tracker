package com.task.tracker.dao.impl;


import com.task.tracker.config.ApplicationConfig;
import com.task.tracker.dao.DaoException;
import com.task.tracker.dao.ProjectDao;
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
public class ProjectDaoImplTest {

    @Autowired
    private ProjectDao projectDao;

    @Test
    public void add() throws DaoException {

        Project project = new Project();
        project.setId(null);
        project.setName("testName");

        Task task = new Task();
        task.setId(null);
        task.setNameTask("testName");
        task.setDescription("TestDescription");
        Set<Task> taskSet = new HashSet<>();
        taskSet.add(task);
        project.setTasks(taskSet);

        User user = new User();
        user.setId(null);
        user.setLastName("TestLastName");
        user.setFirstName("TestFirstName");
        user.setPassword("testPassword");
        user.setEmail("testEmail");
//        user.setRoles("testRoles");
        Set<User> userSet = new HashSet<>();
        userSet.add(user);
        project.setUsers(userSet);

        projectDao.add(project);
        Assert.assertEquals(projectDao.getById(project.getId()).getId(),project.getId());
        Assert.assertEquals(projectDao.getById(project.getId()).getName(),project.getName());
        Assert.assertEquals(projectDao.getById(project.getId()).getTasks().iterator().next().getId(),task.getId());
        Assert.assertEquals(projectDao.getById(project.getId()).getUsers().iterator().next().getId(),user.getId());
        projectDao.remove(project);

    }

    @Test
    public void getAll() throws DaoException {

        Project project = new Project();
        project.setId(null);
        project.setName("testName");

        Task task = new Task();
        task.setId(null);
        task.setNameTask("testName");
        task.setDescription("TestDescription");
        Set<Task> taskSet = new HashSet<>();
        taskSet.add(task);
        project.setTasks(taskSet);

        User user = new User();
        user.setId(null);
        user.setLastName("TestLastName");
        user.setFirstName("TestFirstName");
        user.setPassword("testPassword");
        user.setEmail("testEmail");
//        user.setRoles("testRoles");
        Set<User> userSet = new HashSet<>();
        userSet.add(user);
        project.setUsers(userSet);

        projectDao.add(project);


        List<Project> list = projectDao.getAll();
        Assert.assertNotNull(list);
        Assert.assertTrue(list.size() > 0);
        projectDao.remove(project);
    }

    @Test
    public void getById() throws DaoException {
        Project project = new Project();
        project.setId(null);
        project.setName("testName");

        Task task = new Task();
        task.setId(null);
        task.setNameTask("testName");
        task.setDescription("TestDescription");
        Set<Task> taskSet = new HashSet<>();
        taskSet.add(task);
        project.setTasks(taskSet);

        User user = new User();
        user.setId(null);
        user.setLastName("TestLastName");
        user.setFirstName("TestFirstName");
        user.setPassword("testPassword");
        user.setEmail("testEmail");
//        user.setRoles("Roles");
        Set<User> userSet = new HashSet<>();
        userSet.add(user);
        project.setUsers(userSet);

        projectDao.add(project);
        Assert.assertEquals(projectDao.getById(project.getId()).getId(),project.getId());
        Assert.assertEquals(projectDao.getById(project.getId()).getName(),project.getName());
        Assert.assertEquals(projectDao.getById(project.getId()).getTasks().iterator().next().getId(),task.getId());
        Assert.assertEquals(projectDao.getById(project.getId()).getUsers().iterator().next().getId(),user.getId());
        projectDao.remove(project);

    }

    @Test
    public void update() throws DaoException {
        Project project = new Project();
        project.setId(null);
        project.setName("testName");

        Task task = new Task();
        task.setId(null);
        task.setNameTask("testName");
        task.setDescription("TestDescription");
        Set<Task> taskSet = new HashSet<>();
        taskSet.add(task);
        project.setTasks(taskSet);

        User user = new User();
        user.setId(null);
        user.setLastName("TestLastName");
        user.setFirstName("TestFirstName");
        user.setPassword("testPassword");
        user.setEmail("testEmail");
//        user.setRoles("testRoles");
        Set<User> userSet = new HashSet<>();
        userSet.add(user);
        project.setUsers(userSet);

        projectDao.add(project);
        Assert.assertEquals(projectDao.getById(project.getId()).getId(),project.getId());
        Assert.assertEquals(projectDao.getById(project.getId()).getName(),project.getName());
        Assert.assertEquals(projectDao.getById(project.getId()).getTasks().iterator().next().getId(),task.getId());
        Assert.assertEquals(projectDao.getById(project.getId()).getUsers().iterator().next().getId(),user.getId());

        project.setName("updatetestName");

        task.setNameTask("updatetestName");
        task.setDescription("updateTestDescription");
        taskSet.add(task);
        project.setTasks(taskSet);

        user.setLastName("updateTestLastName");
        user.setFirstName("updateTestFirstName");
        user.setPassword("updatetestPassword");
        user.setEmail("updatetestEmail");
//        user.setRoles("updatetestRoles");
        userSet.add(user);
        project.setUsers(userSet);

        projectDao.update(project);
        Assert.assertEquals(projectDao.getById(project.getId()).getId(),project.getId());
        Assert.assertEquals(projectDao.getById(project.getId()).getName(),project.getName());
        Assert.assertEquals(projectDao.getById(project.getId()).getTasks().iterator().next().getId(),task.getId());
        Assert.assertEquals(projectDao.getById(project.getId()).getUsers().iterator().next().getId(),user.getId());
        projectDao.remove(project);

    }

    @Test
    public void remove() throws DaoException {
        Project project = new Project();
        project.setId(null);
        project.setName("testName");

        Task task = new Task();
        task.setId(null);
        task.setNameTask("testName");
        task.setDescription("TestDescription");
        Set<Task> taskSet = new HashSet<>();
        taskSet.add(task);
        project.setTasks(taskSet);

        User user = new User();
        user.setId(null);
        user.setLastName("TestLastName");
        user.setFirstName("TestFirstName");
        user.setPassword("testPassword");
        user.setEmail("testEmail");
//        user.setRoles("testRoles");
        Set<User> userSet = new HashSet<>();
        userSet.add(user);
        project.setUsers(userSet);

        projectDao.add(project);


        Assert.assertNotNull(projectDao.getById(project.getId()).getId());
        projectDao.remove(project);
        try {
            Assert.assertNull(projectDao.getById(project.getId()).getId());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

}
