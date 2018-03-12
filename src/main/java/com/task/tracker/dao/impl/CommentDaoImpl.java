package com.task.tracker.dao.impl;

import com.task.tracker.dao.CommentDao;
import com.task.tracker.dao.DaoException;
import com.task.tracker.model.Comment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class CommentDaoImpl implements CommentDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Comment comment) throws DaoException {

        Session session = this.sessionFactory.getCurrentSession();
        session.save(comment);

    }

    @Override
    public List<Comment> getAll() throws DaoException {

        Session session = this.sessionFactory.getCurrentSession();
        List<Comment> commentList = session.createQuery("from Comment").list();
        return commentList;
    }

    @Override
    public Comment getById(Long id) throws DaoException {

        Session session = this.sessionFactory.getCurrentSession();
        Comment comment = session.get(Comment.class, new Long(id));
        return comment;
    }

    @Override
    public void update(Comment comment) throws DaoException {

        Session session = this.sessionFactory.getCurrentSession();
        session.update(comment);
    }

    @Override
    public void remove(Comment comment) throws DaoException {

        Session session = this.sessionFactory.getCurrentSession();
        session.remove(comment);

    }
}
