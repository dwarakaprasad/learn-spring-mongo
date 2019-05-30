package com.learn.mongo.springmongodbRef.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "PHONERECORD")
public class PhoneRecord {
    
    public enum PhoneRecordType {
        HOME, MOBILE, WORK
    }
    
    @Id
    private String id;
    private PhoneRecordType type;
    private Long number;
    private Integer extension;
    
    public PhoneRecord() {
        
    }
    
    public PhoneRecord(PhoneRecordType type, Long phoneNumber) {
        this.setType(type);
        this.setNumber(phoneNumber);
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
	 * @return the type
	 */
	public PhoneRecordType getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(PhoneRecordType type) {
		this.type = type;
	}
	/**
	 * @return the number
	 */
	public Long getNumber() {
		return number;
	}
	/**
	 * @param number the number to set
	 */
	public void setNumber(Long number) {
		this.number = number;
	}
	/**
	 * @return the extension
	 */
	public Integer getExtension() {
		return extension;
	}
	/**
	 * @param extension the extension to set
	 */
	public void setExtension(Integer extension) {
		this.extension = extension;
	}
}
