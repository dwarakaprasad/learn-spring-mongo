package com.learn.mongo.springmongodbRef.Repository;

import com.learn.mongo.springmongodbRef.domain.Address;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddressRepository extends MongoRepository<Address, String> {
    
}
