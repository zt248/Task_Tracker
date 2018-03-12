package com.task.tracker.service.impl;

import com.task.tracker.dao.CommentDao;
import com.task.tracker.dao.DaoException;
import com.task.tracker.model.Comment;
import com.task.tracker.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public void add(Comment comment) throws DaoException {
        this.commentDao.add(comment);
    }

    @Override
    public List<Comment> getAll() throws DaoException {
        return this.commentDao.getAll();
    }

    @Override
    public Comment getById(Long id) throws DaoException {
        return this.commentDao.getById(id);
    }

    @Override
    public void update(Comment comment) throws DaoException {
        this.commentDao.update(comment);
    }

    @Override
    public void remove(Comment comment) throws DaoException {
        this.commentDao.remove(comment);
    }
}
