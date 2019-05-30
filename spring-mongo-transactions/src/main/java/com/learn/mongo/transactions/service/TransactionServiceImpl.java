package com.learn.mongo.transactions.service;

import java.util.List;
import java.util.Optional;

import com.learn.mongo.transactions.domain.Account;
import com.learn.mongo.transactions.domain.Withdraw;
import com.learn.mongo.transactions.domain.Deposit;
import com.learn.mongo.transactions.domain.Account.AccountTypeEnum;
import com.learn.mongo.transactions.repository.AccountRepository;
import com.learn.mongo.transactions.repository.DepositRepository;
import com.learn.mongo.transactions.repository.WithdrawRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Scope("prototype")
@Transactional
public class TransactionServiceImpl implements TransactionService {
    
    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private AccountRepository accountRepository;
    
    @Autowired
    private DepositRepository depositRepository;
    
    @Autowired
    private WithdrawRepository withdrawRepository;

	@Override
	public void createAccounts() throws Exception {
        Account a1 = new Account("AC001", AccountTypeEnum.SAVINGS, 5000d);
		Account a2 = new Account("AC002", AccountTypeEnum.SAVINGS, 1000d);
		accountRepository.save(a1);
		accountRepository.save(a2);
	}

	@Override
	public Double withdraw(String accountId, Double amount, Long waitTime) throws InterruptedException {
	    Optional<Account> doutableAccount = accountRepository.findByAccountId(accountId);
		if(doutableAccount.isPresent()) {
		    Thread.sleep(waitTime);
		    doutableAccount.get().setAmount(doutableAccount.get().getAmount() - amount);
		    Thread.sleep(waitTime);
		    withdrawRepository.save(new Withdraw(accountId, amount));
		    accountRepository.save(doutableAccount.get());
		}
		return amount;
	}

	@Override
	public void deposit(String accountId, Double amount, Long waitTime) throws InterruptedException {
		 Optional<Account> doutableAccount = accountRepository.findByAccountId(accountId);
		if(doutableAccount.isPresent()) {
		    doutableAccount.get().setAmount(doutableAccount.get().getAmount() + amount);
		    Thread.sleep(waitTime);
		    depositRepository.save(new Deposit(accountId, amount));
		    accountRepository.save(doutableAccount.get());
		}
	}
	
	@Override
	public List<Account> getAllAccounts() {
	    return accountRepository.findAll();
	}

	@Override
	public Account createAccount(Account account) {
	    if(accountRepository.findByAccountId(account.getAccountId()).isPresent()) {
	        throw new RuntimeException("Account with id " + account.getId() + " already exists");
	    }
	    return accountRepository.save(account);
	}

	@Override
	public Account getAccountByAccountId(String accountId) {
	    Optional<Account> doubtableAccount = accountRepository.findByAccountId(accountId);
	    if(doubtableAccount.isPresent()) {
            return doubtableAccount.get();   
	    }
	    return null;
	}
}
