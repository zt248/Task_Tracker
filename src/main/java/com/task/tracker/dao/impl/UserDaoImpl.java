package com.task.tracker.dao.impl;

import com.task.tracker.dao.DaoException;
import com.task.tracker.dao.UserDao;
import com.task.tracker.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) throws DaoException {

        Session session = this.sessionFactory.getCurrentSession();
        session.save(user);
    }


    @Override
    public List<User> getAll() throws DaoException {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> userList = session.createQuery("from User").list();
        return userList;
    }

    @Override
    public List<User> getDeveloper() throws DaoException {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> developerList = session.createQuery("from User where role = 'ROLE_DEVELOPER'").list();
        return developerList;
//        return null;
    }

    @Override
    public List<User> getDeveloperLastFist(String firstName, String lastName) throws DaoException {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> developerList = session.createQuery("from User where first_name like '%" + firstName + "%' and last_name like '" + lastName + "'  ").list();
        return developerList;
//        return null;
    }

    @Override
    public List<User> developerGetAllProject(String email) throws DaoException {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> developerList = session.createQuery("from User where email = '" + email + "' ").list();
        return developerList;
    }

    @Override
    public User getById(Long id) throws DaoException {

        Session session = this.sessionFactory.getCurrentSession();
        User user = session.get(User.class, new Long(id));
        return user;
    }

    @Override
    public void update(User user) throws DaoException {

        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);

    }

    @Override
    public void remove(User user) throws DaoException {

        Session session = this.sessionFactory.getCurrentSession();
        session.remove(user);

    }
}
