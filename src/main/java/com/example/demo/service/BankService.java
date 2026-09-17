package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankService {

    static List<User> list = new ArrayList<>();

    public List<User> getUsers() {
        return list;
    }
    public User addUser(User user) {
    list.add(user);
    return user;
    }
    public User updateUser(int id, User user) {

        for (int i = 0; i < list.size(); i++) {

            if (list.get(i).getId() == id) {
                list.set(i, user);
                return user;
            }
        }

        return null;
    }
    public String deleteUser(int id) {

        for (User user : list) {

            if (user.getId() == id) {
                list.remove(user);
                return "User deleted successfully";
            }
        }

        return "User not found";
    }
}
