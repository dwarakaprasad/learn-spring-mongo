package com.learn.mongo.springmongo01.service;

import java.util.List;

import com.learn.mongo.springmongo01.domain.Person;
import com.learn.mongo.springmongo01.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class PersonServiceImpl implements PersonService {
    
    @Autowired
	private PersonRepository repository;

	@Override
	public void processPerson() throws Exception {
	    
	    Person p1 = new Person("Father123_" + System.currentTimeMillis(), "Warner");
        p1.setAlive(Boolean.TRUE);
        repository.insert(p1);
        
        List<Person> allData = repository.findAll();
        allData.stream().forEach(eachPerson -> System.out.println(eachPerson));
    }
}