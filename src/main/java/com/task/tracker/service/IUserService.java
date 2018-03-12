package com.task.tracker.service;

import com.task.tracker.model.User;
import com.task.tracker.model.VerificationToken;



public interface IUserService {

    User getUser(String verificationToken);

    void createVerificationTokenForUser(User user, String token);

    VerificationToken getVerificationToken(String VerificationToken);

    VerificationToken generateNewVerificationToken(String token);

    String validateVerificationToken(String token);

}