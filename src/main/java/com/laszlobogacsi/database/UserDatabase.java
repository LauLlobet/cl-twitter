package com.laszlobogacsi.database;

import com.laszlobogacsi.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserDatabase {
    private List<User> users;

    public UserDatabase() {
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public List<User> getAllUsers() {
        return this.users;
    }

    public User getUserById(long id) {
        return findUserBy(id);
    }


    private User findUserBy(long id) {
        return this.users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
