package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BankController {

    @Autowired
    BankService bankService;

    @GetMapping("/users")
    public List<User> getUsers() {
        return bankService.getUsers();
    }
     @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        return bankService.addUser(user);
    }
     @PutMapping("/users/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        return bankService.updateUser(id, user);
    }
    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable int id) {
        return bankService.deleteUser(id);
    }
}