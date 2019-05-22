package com.learn.mongo.springmongo01.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.learn.mongo.springmongo01.domain.Person;
import java.util.List;

public interface PersonRepository extends MongoRepository<Person, String> {

    public Person findByFirstName(String firstName);
    public List<Person> findByLastName(String lastName);

}
