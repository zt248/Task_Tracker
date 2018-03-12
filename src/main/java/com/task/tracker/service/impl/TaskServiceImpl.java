package com.task.tracker.service.impl;


import com.task.tracker.dao.DaoException;
import com.task.tracker.dao.TaskDao;
import com.task.tracker.model.Task;
import com.task.tracker.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskDao taskDao;

    @Override
    public void add(Task task) throws DaoException {
        this.taskDao.add(task);
    }

    @Override
    public List<Task> getAll() throws DaoException {
        return this.taskDao.getAll();
    }

    @Override
    public Task getById(Long id) throws DaoException {
        return this.taskDao.getById(id);
    }

    @Override
    public void update(Task task) throws DaoException {
        this.taskDao.update(task);
    }

    @Override
    public void remove(Task task) throws DaoException {
        this.taskDao.remove(task);
    }
}
