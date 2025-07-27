package com.bank.controller;


import com.bank.dto.createAccountDto;
import com.bank.model.Account;
import com.bank.model.User;
import com.bank.service.AccountService;
import com.bank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@RestController 
@RequestMapping("/api/accounts") 
public class AccountController {

    private final AccountService accountService;
    private final UserService userService; 
   
    public AccountController(AccountService accountService, UserService userService) {
        this.accountService = accountService;
        this.userService = userService;
    }

    
    @PostMapping 
    public ResponseEntity<Account> createAccount(@RequestBody createAccountDto dto) {
    	
    	Account account = accountService.createAccount(dto);
        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }

    
    @GetMapping // Maps GET requests to /api/accounts.
    public ResponseEntity <List<Account>> getUserAccounts(User User) {
    	List<Account> accountsByUser = accountService.findAccountsByUser(User);
        
        return new ResponseEntity<List<Account>>(accountsByUser, HttpStatus.OK);
    }

    
    @GetMapping("/{accountNumber}") // Maps GET requests to /api/accounts/{accountNumber}.
    public ResponseEntity<Account> getAccountByNumber(@PathVariable String accountNumber) {
        Account account = accountService.findByAccountNumber(accountNumber);
        return new ResponseEntity<Account>(account, HttpStatus.OK);
                }

    
    @GetMapping("/{accountNumber}/balance") // Maps GET requests to /api/accounts/{accountNumber}/balance.
    public ResponseEntity<BigDecimal> getAccountBalance(@PathVariable String accountNumber) {
        BigDecimal balance = accountService.getAccountBalance(accountNumber);
        return  new ResponseEntity<BigDecimal>(balance, HttpStatus.OK);
                }
}
