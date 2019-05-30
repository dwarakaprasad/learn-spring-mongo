package com.learn.mongo.springmongo01;

import com.learn.mongo.springmongo01.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;


@SpringBootApplication
public class SpringMongo01Application implements CommandLineRunner {

    @Autowired
    private PersonService personService;

	public static void main(String[] args) {
		SpringApplication.run(SpringMongo01Application.class, args);
	}
	
	@Override
	@Transactional(readOnly = true)
	public void run(String... args) throws Exception {
        personService.processPerson();
	}
}
