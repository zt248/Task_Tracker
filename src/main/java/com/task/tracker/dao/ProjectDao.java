package com.task.tracker.dao;

import com.task.tracker.model.Project;

import java.util.List;

public interface ProjectDao {
    //CRUD

    //create
    void add(Project project) throws DaoException;

    //read
    List<Project> getAll() throws DaoException;

  //read
    List<Project> getAllProject(String userEmail) throws DaoException;


    Project getById(Long id) throws DaoException;

    //update
    void update(Project project) throws DaoException;



    //detele
    void remove(Project project) throws DaoException;
}
