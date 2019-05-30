package com.learn.mongo.transactions.rest;

import java.net.URI;
import java.util.List;

import com.learn.mongo.transactions.domain.Account;
import com.learn.mongo.transactions.dto.AccountTransactionDTO;
import com.learn.mongo.transactions.service.TransactionService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(path = "/transact")
public class TransactionMgtResource {
    
    private final TransactionService transactionService;
    
    public TransactionMgtResource(TransactionService transactionService) {
        this.transactionService = transactionService;
    }
    
    @ResponseBody
    @GetMapping(path = "/account/{accountId}")
    public Account getAllAccounts(@PathVariable() String accountId) {
        return transactionService.getAccountByAccountId(accountId);
    }
    
    @ResponseBody
    @GetMapping(path = "/accounts")
    public List<Account> getAllAccounts() {
        return transactionService.getAllAccounts();
    }
    
    @PostMapping(path = "/account")
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        transactionService.createAccount(account);
        
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{accountId}")
                                    .buildAndExpand(account.getAccountId())
                                    .toUri();
         
        return ResponseEntity.created(location).build();
    }
    
    @PostMapping(path = "/deposit")
    public ResponseEntity<Account> deposit(@RequestBody AccountTransactionDTO deposit) throws InterruptedException {
        
        transactionService.deposit(deposit.getAccountId(), deposit.getAmount(), deposit.getWaitTime());
        
        URI location = ServletUriComponentsBuilder.fromCurrentContextPath()
                                    .path("/transact/account/{accountId}")
                                    .buildAndExpand(deposit.getAccountId())
                                    .toUri();
         
        return ResponseEntity.created(location).build();
    }
    
    @PostMapping(path = "/withdraw")
    public ResponseEntity<Account> withdraw(@RequestBody AccountTransactionDTO deposit) throws InterruptedException {
        
        transactionService.withdraw(deposit.getAccountId(), deposit.getAmount(), deposit.getWaitTime());
        
        URI location = ServletUriComponentsBuilder.fromCurrentContextPath()
                                    .path("/transact/account/{accountId}")
                                    .buildAndExpand(deposit.getAccountId())
                                    .toUri();
         
        return ResponseEntity.created(location).build();
    }
}
