package com.task.tracker.service.impl;


import com.task.tracker.dao.DaoException;
import com.task.tracker.dao.UserDao;
import com.task.tracker.model.User;
import com.task.tracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public void add(User user) throws DaoException {
        this.userDao.add(user);
    }

    @Override
    public List<User> getAll() throws DaoException {
        return this.userDao.getAll();
    }

    @Override
    public User getById(Long id) throws DaoException {
        return this.userDao.getById(id);
    }

    @Override
    public void update(User user) throws DaoException {
        this.userDao.update(user);
    }

    @Override
    public void remove(User user) throws DaoException {
        this.userDao.remove(user);
    }
}
