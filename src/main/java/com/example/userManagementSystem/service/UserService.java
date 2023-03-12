package com.example.userManagementSystem.service;

import com.example.userManagementSystem.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class UserService {
    private static List<User> users = new ArrayList<>();

    private static int id = 0;

    static {
        users.add(new User(++id, "Faisal Ali", "faisalali549", "Gopalganj, Bihar", 9144914356L));
        users.add(new User(++id, "Ramiz Raza", "ramizraza786", "Gopalganj, Bihar", 9877556184L));
        users.add(new User(++id, "Parwez Alam", "parwezalam1470", "Gopalganj, Bihar", 9340826843L));
        users.add(new User(++id, "Zubair Ali", "zubairali546", "Gopalganj, Bihar", 7654429296L));
        users.add(new User(++id, "Zoya Siddique", "zoya549", "Gopalganj, Bihar", 7250200000L));
        users.add(new User(++id, "Md Arshad", "mdarshad221", "Gopalganj, Bihar", 7909042814L));
        users.add(new User(++id, "Sarwar Ali", "sarwarali770", "Gopalganj, Bihar", 9038674866L));
    }

    public List<User> findAllUser() {
        return users;
    }

    public User findById(int id) {
        Predicate<? super User> predicate = user -> user.getUserId() == id;
        User user = users.stream().filter(predicate).findFirst().get();
        return user;
    }
    public void addUser(User user) {
        users.add(user);
    }

    public void deleteUser(int id) {
        Predicate<? super User> predicate = user -> user.getUserId() == id;
        users.removeIf(predicate);
    }

    public void updateUser(int id, User newUser) {
//       1 - find user
//       2 - update user

        User user = findById(id);
        user.setUserId(newUser.getUserId());
        user.setName(newUser.getName());
        user.setUserName(newUser.getUserName());
        user.setAddress(newUser.getAddress());
        user.setContact(newUser.getContact());
    }
}
