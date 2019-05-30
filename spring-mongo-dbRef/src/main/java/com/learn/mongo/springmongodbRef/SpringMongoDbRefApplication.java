package com.learn.mongo.springmongodbRef;

import java.util.Optional;

import com.learn.mongo.springmongodbRef.Repository.AddressRepository;
import com.learn.mongo.springmongodbRef.Repository.PersonRepository;
import com.learn.mongo.springmongodbRef.Repository.PhoneRecordRepository;
import com.learn.mongo.springmongodbRef.domain.Address;
import com.learn.mongo.springmongodbRef.domain.Person;
import com.learn.mongo.springmongodbRef.domain.PhoneRecord;
import com.learn.mongo.springmongodbRef.domain.PhoneRecord.PhoneRecordType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringMongoDbRefApplication implements CommandLineRunner {
    
    @Autowired
    private AddressRepository addressRepo;
    
    @Autowired
    private PersonRepository personRepo;
    
    @Autowired
    private PhoneRecordRepository phonerecordRepo;

	public static void main(String[] args) {
		SpringApplication.run(SpringMongoDbRefApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	    
	   addressRepo.deleteAll();
	   personRepo.deleteAll();
	    
	   Address a1 = new Address();
	   a1.setStreet01("5 Walter St");
	   a1.setStreet02("Apt # 33421");
	   a1.setCity("Lenexa");
	   a1.setZip("12265");
	   a1.setCounty("Tomcat");
	   a1.setState("MN");
	   a1.setCountry("USA");
	   addressRepo.save(a1);
	   
	   PhoneRecord pr1 = new PhoneRecord(PhoneRecordType.MOBILE, 7326343316L);
	   phonerecordRepo.save(pr1);
	   PhoneRecord pr2 = new PhoneRecord(PhoneRecordType.HOME, 9135567415L);
	   phonerecordRepo.save(pr2);
	   
	   Person p = new Person("Andrew", "Simons", a1);
	   p.addPhoneReneRecord(pr1);
	   p.addPhoneReneRecord(pr2);
	   personRepo.save(p);
	   
	   Optional<Person> questionablePerson = personRepo.findByFirstName("Andrew");
	   if(questionablePerson.isPresent()) {
	       System.out.println(questionablePerson.get().getId() + " ---------------------------- " +  questionablePerson.get().getAddress().getId());
	   }
	}
}