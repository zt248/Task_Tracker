package com.task.tracker.dao.impl;

import com.task.tracker.dao.DaoException;
import com.task.tracker.dao.TaskDao;
import com.task.tracker.model.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class TaskDaoImpl implements TaskDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Task task) throws DaoException {

        Session session = this.sessionFactory.getCurrentSession();
        session.save(task);

    }

    @Override
    public List<Task> getAll() throws DaoException {

        Session session = this.sessionFactory.getCurrentSession();
        List<Task> taskList = session.createQuery("from Task").list();
        return taskList;
    }

    @Override
    public List<Task> getProjectTask(Long id) throws DaoException {
        Session session = this.sessionFactory.getCurrentSession();
        List<Task> taskList = session.createQuery("from Task where project_id = '" + id + "'").list();
        return taskList;
    }


    @Override
    public Task getById(Long id) throws DaoException {
        Session session = this.sessionFactory.getCurrentSession();
        Task task = session.get(Task.class, new Long(id));
        return task;
    }

    @Override
    public void update(Task task) throws DaoException {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(task);
    }

    @Override
    public void remove(Task task) throws DaoException {
        Session session = this.sessionFactory.getCurrentSession();
        session.remove(task);

    }
}
