package com.learn.mongo.transactions.service;

import java.util.List;

import com.learn.mongo.transactions.domain.Account;

public interface TransactionService {
    
    public void createAccounts() throws Exception;
    
    public Double withdraw(String accountId, Double amount, Long waitTime) throws InterruptedException;
    
    public void deposit(String accountId, Double amount, Long waitTime) throws InterruptedException;
    
    public List<Account> getAllAccounts();

	public Account createAccount(Account account);

	public Account getAccountByAccountId(String accountId);
    
}
