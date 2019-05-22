package com.learn.mongo.springmongo01;

import com.learn.mongo.springmongo01.domain.Person;
import com.learn.mongo.springmongo01.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringMongo01Application implements CommandLineRunner {
    
    @Autowired
	private PersonRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringMongo01Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
        Person p1 = new Person("Father", "LastName");
        repository.insert(p1);
	}
}
