package com.task.tracker.service.impl;

import com.task.tracker.dao.DaoException;
import com.task.tracker.dao.ProjectDao;
import com.task.tracker.model.Project;
import com.task.tracker.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDao projectDao;

    @Override
    public void add(Project project) throws DaoException {
        this.projectDao.add(project);
    }

    @Override
    public List<Project> getAll() throws DaoException {
        return this.projectDao.getAll();
    }

    @Override
    public Project getById(Long id) throws DaoException {
        return this.projectDao.getById(id);
    }

    @Override
    public void update(Project project) throws DaoException {
        this.projectDao.update(project);
    }

    @Override
    public void remove(Project project) throws DaoException {
        this.projectDao.remove(project);
    }
}
