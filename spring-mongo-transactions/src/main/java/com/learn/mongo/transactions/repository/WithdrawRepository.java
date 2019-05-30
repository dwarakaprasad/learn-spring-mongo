package com.learn.mongo.transactions.repository;

import com.learn.mongo.transactions.domain.Withdraw;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface WithdrawRepository extends MongoRepository<Withdraw, String> {

}