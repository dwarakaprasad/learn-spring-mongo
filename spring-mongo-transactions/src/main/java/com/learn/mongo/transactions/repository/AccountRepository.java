package com.learn.mongo.transactions.repository;

import java.util.Optional;

import com.learn.mongo.transactions.domain.Account;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account, String> {
    
    public Optional<Account> findByAccountId(String accountId);
    
}
