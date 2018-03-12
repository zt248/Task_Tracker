package com.task.tracker.dao;

import com.task.tracker.model.Role;

import java.util.List;

public interface RoleDao {

    //CRUD

    //create
    void add(Role role) throws DaoException;

    //read
    List<Role> getAll() throws DaoException;

    Role getById(Long id) throws DaoException;

    //update
    void update(Role role) throws DaoException;


    //detele
    void remove(Role role) throws DaoException;

}
