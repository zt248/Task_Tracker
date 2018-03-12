package com.task.tracker.service;

import com.task.tracker.dao.DaoException;
import com.task.tracker.model.Project;

import java.util.List;

public interface ProjectService {
    //CRUD

    //create
    void add(Project project) throws DaoException;

    //read
    List<Project> getAll() throws DaoException;

    Project getById(Long id) throws DaoException;

    //update
    void update(Project project) throws DaoException;


    //detele
    void remove(Project project) throws DaoException;
}
