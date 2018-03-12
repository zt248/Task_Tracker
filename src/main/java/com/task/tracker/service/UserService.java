package com.task.tracker.service;

import com.task.tracker.dao.DaoException;
import com.task.tracker.model.User;

import java.util.List;

public interface UserService {

    //CRUD

    //create
    void add(User user) throws DaoException;

    //read
    List<User> getAll() throws DaoException;

    User getById(Long id) throws DaoException;

    //update
    void update(User user) throws DaoException;


    //detele
    void remove(User user) throws DaoException;

}
