package com.learn.mongo.transactions.dto;

public class AccountTransactionDTO {
    
    private String accountId;
    private Double amount;
    private Long waitTime;
    
    
	
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
	 * @return the waitTime
	 */
	public Long getWaitTime() {
		return waitTime;
	}
	/**
	 * @param waitTime the waitTime to set
	 */
	public void setWaitTime(Long waitTime) {
		this.waitTime = waitTime;
	}
}
