package com.task.tracker.dao.impl;


import com.task.tracker.config.ApplicationConfig;
import com.task.tracker.dao.CommentDao;
import com.task.tracker.dao.DaoException;
import com.task.tracker.model.Comment;
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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class CommentDaoImplTest {


    @Autowired
    private CommentDao commentDao;

    @Test
    public void add() throws DaoException {

        Comment comment = new Comment();
        comment.setId(null);
        comment.setTextComment("testTestComment");

        Task task = new Task();
        task.setId(null);
        task.setNameTask("testName");
        task.setDescription("TestDescription");
        comment.setTask(task);

        User user = new User();
        user.setId(null);
        user.setLastName("TestLastName");
        user.setFirstName("TestFirstName");
        user.setPassword("testPassword");
        user.setEmail("testEmail");
//        user.setRoles("testRoles");
        comment.setUser(user);

        commentDao.add(comment);

        Assert.assertEquals(commentDao.getById(comment.getId()).getId(),comment.getId());
        Assert.assertEquals(commentDao.getById(comment.getId()).getTextComment(),comment.getTextComment());
        Assert.assertEquals(commentDao.getById(comment.getId()).getTask().getId(),task.getId());
        Assert.assertEquals(commentDao.getById(comment.getId()).getUser().getId(),user.getId());

        commentDao.remove(comment);

    }

    @Test
    public void getAll() throws DaoException {

        Comment comment = new Comment();
        comment.setId(null);
        comment.setTextComment("testTestComment");

        Task task = new Task();
        task.setId(null);
        task.setNameTask("testName");
        task.setDescription("TestDescription");
        comment.setTask(task);

        User user = new User();
        user.setId(null);
        user.setLastName("TestLastName");
        user.setFirstName("TestFirstName");
        user.setPassword("testPassword");
        user.setEmail("testEmail");
//        user.setRoles("testRoles");
        comment.setUser(user);

        commentDao.add(comment);
        List<Comment> list = commentDao.getAll();
        Assert.assertNotNull(list);
        Assert.assertTrue(list.size() > 0);
        commentDao.remove(comment);
    }

    @Test
    public void getById() throws DaoException {
        Comment comment = new Comment();
        comment.setId(null);
        comment.setTextComment("testTestComment");

        Task task = new Task();
        task.setId(null);
        task.setNameTask("testName");
        task.setDescription("TestDescription");
        comment.setTask(task);

        User user = new User();
        user.setId(null);
        user.setLastName("TestLastName");
        user.setFirstName("TestFirstName");
        user.setPassword("testPassword");
        user.setEmail("testEmail");
//        user.setRoles("Roles");
        comment.setUser(user);

        commentDao.add(comment);

        Assert.assertEquals(commentDao.getById(comment.getId()).getId(),comment.getId());
        Assert.assertEquals(commentDao.getById(comment.getId()).getTextComment(),comment.getTextComment());
        Assert.assertEquals(commentDao.getById(comment.getId()).getTask().getId(),task.getId());
        Assert.assertEquals(commentDao.getById(comment.getId()).getUser().getId(),user.getId());

        commentDao.remove(comment);
    }

    @Test
    public void update() throws DaoException {
        Comment comment = new Comment();
        comment.setId(null);
        comment.setTextComment("testTestComment");

        Task task = new Task();
        task.setId(null);
        task.setNameTask("testName");
        task.setDescription("TestDescription");
        comment.setTask(task);

        User user = new User();
        user.setId(null);
        user.setLastName("TestLastName");
        user.setFirstName("TestFirstName");
        user.setPassword("testPassword");
        user.setEmail("testEmail");
//        user.setRoles("testRoles");
        comment.setUser(user);

        commentDao.add(comment);

        Assert.assertEquals(commentDao.getById(comment.getId()).getId(),comment.getId());
        Assert.assertEquals(commentDao.getById(comment.getId()).getTextComment(),comment.getTextComment());
        Assert.assertEquals(commentDao.getById(comment.getId()).getTask().getId(),task.getId());
        Assert.assertEquals(commentDao.getById(comment.getId()).getUser().getId(),user.getId());

        comment.setTextComment("updatetestTestComment");

        task.setNameTask("updatetestName");
        task.setDescription("updateTestDescription");
        comment.setTask(task);

        user.setLastName("updateTestLastName");
        user.setFirstName("updateTestFirstName");
        user.setPassword("updatetestPassword");
        user.setEmail("updatetestEmail");
//        user.setRoles("updatetestRoles");
        comment.setUser(user);

        commentDao.update(comment);

        Assert.assertEquals(commentDao.getById(comment.getId()).getId(),comment.getId());
        Assert.assertEquals(commentDao.getById(comment.getId()).getTextComment(),comment.getTextComment());
        Assert.assertEquals(commentDao.getById(comment.getId()).getTask().getId(),task.getId());
        Assert.assertEquals(commentDao.getById(comment.getId()).getUser().getId(),user.getId());

        commentDao.remove(comment);
    }

    @Test
    public void remove() throws DaoException {
        Comment comment = new Comment();
        comment.setId(null);
        comment.setTextComment("testTestComment");

        Task task = new Task();
        task.setId(null);
        task.setNameTask("testName");
        task.setDescription("TestDescription");
        comment.setTask(task);

        User user = new User();
        user.setId(null);
        user.setLastName("TestLastName");
        user.setFirstName("TestFirstName");
        user.setPassword("testPassword");
        user.setEmail("testEmail");
//        user.setRoles("testRoles");
        comment.setUser(user);

        commentDao.add(comment);


        Assert.assertNotNull(commentDao.getById(comment.getId()).getId());
        commentDao.remove(comment);
        try {
            Assert.assertNull(commentDao.getById(comment.getId()).getId());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

}
