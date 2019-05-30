package com.learn.mongo.springmongodbRef.Repository;

import com.learn.mongo.springmongodbRef.domain.PhoneRecord;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PhoneRecordRepository extends MongoRepository<PhoneRecord, String> {

}
