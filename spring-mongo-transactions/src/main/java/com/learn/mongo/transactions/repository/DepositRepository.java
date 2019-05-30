package com.learn.mongo.transactions.repository;

import com.learn.mongo.transactions.domain.Deposit;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface DepositRepository extends MongoRepository<Deposit, String> {
    
}