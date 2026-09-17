package com.example.demo.service;

import com.example.demo.model.BankAccount;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

    static List<BankAccount> list = new ArrayList<>();

    public List<BankAccount> getAccounts() {
        return list;
    }

    public BankAccount addAccount(BankAccount account) {
        list.add(account);
        return account;
    }

    public BankAccount updateAccount(int accountNumber, BankAccount account) {

        for (int i = 0; i < list.size(); i++) {

            if (list.get(i).getAccountNumber() == accountNumber) {
                list.set(i, account);
                return account;
            }
        }

        return null;
    }

    public String deleteAccount(int accountNumber) {

        for (BankAccount account : list) {

            if (account.getAccountNumber() == accountNumber) {
                list.remove(account);
                return "Account deleted successfully";
            }
        }

        return "Account not found";
    }
}