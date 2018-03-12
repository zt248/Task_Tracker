package com.task.tracker.service;

import com.task.tracker.dao.DaoException;
import com.task.tracker.model.Comment;

import java.util.List;

public interface CommentService {
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
