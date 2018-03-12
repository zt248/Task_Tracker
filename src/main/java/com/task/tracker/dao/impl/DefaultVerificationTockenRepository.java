package com.task.tracker.dao.impl;

import com.task.tracker.dao.VerificationTokenRepository;
import com.task.tracker.model.VerificationToken;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class DefaultVerificationTockenRepository implements VerificationTokenRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public VerificationToken findByToken(String token) {
        return (VerificationToken) sessionFactory.getCurrentSession().createQuery("from VerificationToken where token = '"+token+"'").list().get(0);
    }

    @Override
    public VerificationToken save(VerificationToken myToken) {
        sessionFactory.getCurrentSession().save(myToken);
        return myToken;
    }

    @Override
    public void delete(VerificationToken verificationToken) {
        sessionFactory.getCurrentSession().delete(verificationToken);
    }
}
