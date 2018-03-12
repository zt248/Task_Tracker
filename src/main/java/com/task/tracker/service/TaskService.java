package com.task.tracker.service;

import com.task.tracker.dao.DaoException;
import com.task.tracker.model.Task;

import java.util.List;

public interface TaskService {

    //CRUD

    //create
    void add(Task task) throws DaoException;

    //read
    List<Task> getAll() throws DaoException;

    Task getById(Long id) throws DaoException;

    //update
    void update(Task task) throws DaoException;


    //detele
    void remove(Task task) throws DaoException;

}
