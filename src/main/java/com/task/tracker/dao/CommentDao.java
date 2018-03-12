package com.task.tracker.dao;

import com.task.tracker.model.Comment;

import java.util.List;

public interface CommentDao {
    //CRUD

    //create
    void add(Comment comment) throws DaoException;

    //read
    List<Comment> getAll() throws DaoException;

    Comment getById(Long id) throws DaoException;

    //update
    void update(Comment comment) throws DaoException;


    //detele
    void remove(Comment comment) throws DaoException;

}
