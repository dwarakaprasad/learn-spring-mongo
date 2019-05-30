package com.learn.mongo.transactions.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Account {
    
    public enum AccountTypeEnum {
        SAVINGS, CHECKING, CREDIT, LOAN
    }
    
    @Id
    private String id;
    private String accountId;
    private AccountTypeEnum type;
    private Double amount;
    @Version
    private Long version;
    
    public Account(String accountId, AccountTypeEnum type, Double amount) {
        this.accountId = accountId;
        this.type = type;
        this.amount = amount;
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
	 * @return the accountId
	 */
	public String getAccountId() {
		return accountId;
	}
	/**
	 * @param accountId the accountId to set
	 */
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	/**
	 * @return the type
	 */
	public AccountTypeEnum getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(AccountTypeEnum type) {
		this.type = type;
	}
	
	public String toString() {
	    return id + " " + accountId + " " + type + " " + amount;
	}

	/**
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}



	/**
	 * @return the version
	 */
	public Long getVersion() {
		return version;
	}



	/**
	 * @param version the version to set
	 */
	public void setVersion(Long version) {
		this.version = version;
	}
}
