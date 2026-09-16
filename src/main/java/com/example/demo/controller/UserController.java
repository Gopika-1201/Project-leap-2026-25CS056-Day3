package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final List<User> users = new ArrayList<>();

    public UserController() {
        
        users.add(new User(1, "Gopika", "gopika123@gmail.com"));
        users.add(new User(2, "Riya", "riya321@gmail.com"));
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        return users.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found"));
    }

    
    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        int nextId = users.stream().mapToInt(User::getId).max().orElse(0) + 1;
        user.setId(nextId);
        users.add(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

   
    @PutMapping("/{id}")
    public ResponseEntity<?> replaceUser(@PathVariable int id, @RequestBody User updatedData) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                updatedData.setId(id);
                users.set(i, updatedData);
                return ResponseEntity.ok(updatedData);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        boolean removed = users.removeIf(u -> u.getId() == id);
        if (removed) {
            return ResponseEntity.ok("User with ID " + id + " deleted successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }
}