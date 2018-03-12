package com.task.tracker.dao;

import com.task.tracker.model.VerificationToken;


public interface VerificationTokenRepository{

    VerificationToken findByToken(String token);

    VerificationToken save(VerificationToken myToken);

    void delete(VerificationToken verificationToken);

//    VerificationToken findByUser(User user);

//    Stream<VerificationToken> findAllByExpiryDateLessThan(Date now);

//    void deleteByExpiryDateLessThan(Date now);

//    @Modifying
//    @Query("delete from VerificationToken t where t.expiryDate <= ?1")
//    void deleteAllExpiredSince(Date now);
}