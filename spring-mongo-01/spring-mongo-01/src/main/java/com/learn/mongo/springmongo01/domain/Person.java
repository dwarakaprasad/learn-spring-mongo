 package com.learn.mongo.springmongo01.domain;

import org.springframework.data.annotation.Id;


public class Person {

    @Id
    public String id;

    public String firstName;
    public String lastName;
    public Boolean isAlive = Boolean.FALSE;

    public Person() {}

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, firstName='%s', lastName='%s', isAlive='%s']",
                id, firstName, lastName, isAlive);
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

	
	public Boolean isAlive() {
		return isAlive;
	}
	
	public void setAlive(Boolean isAlive) {
		this.isAlive = isAlive;
	}

}
