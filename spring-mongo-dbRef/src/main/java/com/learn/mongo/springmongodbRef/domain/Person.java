package com.learn.mongo.springmongodbRef.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "PERSON")
public class Person {

    @Id
    private String id;

    private String firstName;
    private String lastName;

    @DBRef
    private Address address;
    
    @DBRef
    private List<PhoneRecord> phoneNumbers = new ArrayList<PhoneRecord>();

    public Person() {
        
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public Person(String firstName, String lastName, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.setAddress(address);
    }
    
    public Person(String firstName, String lastName, Address address, List<PhoneRecord> phonerecords) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.setPhoneNumbers(phoneNumbers);
        this.setAddress(address);
    }

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * @return the phoneNumbers
	 */
	public List<PhoneRecord> getPhoneNumbers() {
	    if(phoneNumbers == null)
	       return new ArrayList<PhoneRecord>();
		return phoneNumbers;
	}

	/**
	 * @param phoneNumbers the phoneNumbers to set
	 */
	public void setPhoneNumbers(List<PhoneRecord> phoneNumbers) {
		getPhoneNumbers().addAll(phoneNumbers);
	}
	
	public void addPhoneReneRecord(PhoneRecord phoneRecord) {
	    getPhoneNumbers().add(phoneRecord);
	}
}
