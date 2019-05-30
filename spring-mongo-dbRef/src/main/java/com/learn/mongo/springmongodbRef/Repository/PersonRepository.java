package com.learn.mongo.springmongodbRef.Repository;

import java.util.List;
import java.util.Optional;

import com.learn.mongo.springmongodbRef.domain.Person;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, String> {
    public Optional<Person> findByFirstName(String firstName);
    public List<Person> findByLastName(String lastName);

}
