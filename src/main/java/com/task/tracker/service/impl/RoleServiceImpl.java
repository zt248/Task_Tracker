package com.task.tracker.service.impl;

import com.task.tracker.dao.DaoException;
import com.task.tracker.dao.RoleDao;
import com.task.tracker.model.Role;
import com.task.tracker.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public void add(Role role) throws DaoException {
        this.roleDao.add(role);
    }

    @Override
    public List<Role> getAll() throws DaoException {
        return this.roleDao.getAll();
    }

    @Override
    public Role getById(Long id) throws DaoException {
        return this.roleDao.getById(id);
    }

    @Override
    public void update(Role role) throws DaoException {
        this.roleDao.update(role);
    }

    @Override
    public void remove(Role role) throws DaoException {
        this.roleDao.remove(role);
    }
}
