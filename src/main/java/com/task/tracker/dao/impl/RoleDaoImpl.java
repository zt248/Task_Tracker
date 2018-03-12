package com.task.tracker.dao.impl;

import com.task.tracker.dao.DaoException;
import com.task.tracker.dao.RoleDao;
import com.task.tracker.model.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class RoleDaoImpl implements RoleDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Role role) throws DaoException {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(role);
    }

    @Override
    public List<Role> getAll() throws DaoException {
        Session session = this.sessionFactory.getCurrentSession();
        List<Role> roleList = session.createQuery("from Role").list();
        return roleList;
    }

    @Override
    public Role getById(Long id) throws DaoException {
        Session session = this.sessionFactory.getCurrentSession();
        Role role = session.get(Role.class, new Long(id));
        return role;
    }

    @Override
    public void update(Role role) throws DaoException {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(role);
    }

    @Override
    public void remove(Role role) throws DaoException {
        Session session = this.sessionFactory.getCurrentSession();
        session.delete(role);
    }
}
