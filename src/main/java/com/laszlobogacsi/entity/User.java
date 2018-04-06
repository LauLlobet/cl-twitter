package com.laszlobogacsi.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * User entity, that hold information for the users' name, and a list of user names that the user follows
 */
/*
public class UserName{
    private final String name;

    public UserName(String name) {
        this.name = name;
    }

    public String asString(){
        return name;s
    }
}*/
public class User {
    private final String name; // SMELL: primitive obsession
    private List<String> followsNameList;

    /**
     * Constructor assigns an empty follows list on creation
     * @param name
     */
    public User(String name) {
        this.name = name;
        this.followsNameList = new ArrayList<>();
    }

    public boolean follow(String userName)  {
        return followsNameList.add(userName);
    }

    public String getName() {
        return name;
    }

    public List<String> getFollowsNameList() {
        return new ArrayList<>(followsNameList);
    }
}
