package com.task.tracker.dao;

import com.task.tracker.model.Task;

import java.util.List;

public interface TaskDao {

    //CRUD

    //create
    void add(Task task) throws DaoException;

    //read
    List<Task> getAll() throws DaoException;

    List<Task> getProjectTask(Long id) throws DaoException;

    Task getById(Long id) throws DaoException;

    //update
    void update(Task task) throws DaoException;


    //detele
    void remove(Task task) throws DaoException;

}
