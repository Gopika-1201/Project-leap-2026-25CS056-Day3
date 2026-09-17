package com.example.demo.controller;

import com.example.demo.model.BankAccount;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/accounts")
    public List<BankAccount> getAccounts() {
        return accountService.getAccounts();
    }

    @PostMapping("/accounts")
    public BankAccount addAccount(@RequestBody BankAccount account) {
        return accountService.addAccount(account);
    }

    @PutMapping("/accounts/{accountNumber}")
    public BankAccount updateAccount(
            @PathVariable int accountNumber,
            @RequestBody BankAccount account) {

        return accountService.updateAccount(accountNumber, account);
    }

    @DeleteMapping("/accounts/{accountNumber}")
    public String deleteAccount(@PathVariable int accountNumber) {
        return accountService.deleteAccount(accountNumber);
    }
}