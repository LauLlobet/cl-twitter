package com.laszlobogacsi.database;

import com.laszlobogacsi.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementaiton of a simple in memory database represented by an ArrayList
 */
public class UserDatabase {
    private List<User> users;

    public UserDatabase() {
        this.users = new ArrayList<>();
    }

    public boolean addUser(User user) {
        return this.users.add(user);
    }

    public List<User> getAllUsers() {
        return this.users;
    }

    public User getUserByName(String name) {
        return findUserBy(name);
    }

    public boolean isPresent(String name) {
        return findUserBy(name) != null;
    }

    /**
     * Filters for a username to return a user for the given name
     * @param name string user name
     * @return a User object for the given unique name
     */
    private User findUserBy(String name) {
        return this.users.stream()
                .filter(user -> name.equals(user.getName()))
                .findFirst()
                .orElse(null);
    }
}
