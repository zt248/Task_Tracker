package com.task.tracker.dao.impl;

import com.task.tracker.dao.DaoException;
import com.task.tracker.dao.ProjectDao;
import com.task.tracker.model.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class ProjectDaoImpl implements ProjectDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Project project) throws DaoException {

        Session session = this.sessionFactory.getCurrentSession();
        session.save(project);

    }

    @Override
    public List<Project> getAll() throws DaoException {

        Session session = this.sessionFactory.getCurrentSession();
        List<Project> projectList = session.createQuery("from Project").list();
        return projectList;
    }

    @Override
    public List<Project> getAllProject(String userEmail) throws DaoException {

        Session session = this.sessionFactory.getCurrentSession();
        List<Project> projectList = session.createQuery("from Project as project join project.users as user where user.email = '"+userEmail+"'").list();
        return projectList;
    }



    @Override
    public Project getById(Long id) throws DaoException {

        Session session = this.sessionFactory.getCurrentSession();
        Project project = session.get(Project.class, new Long(id));
        return project;
    }

    @Override
    public void update(Project project) throws DaoException {

        Session session = this.sessionFactory.getCurrentSession();
        session.update(project);

    }

    @Override
    public void remove(Project project) throws DaoException {

        Session session = this.sessionFactory.getCurrentSession();
        session.remove(project);

    }
}
