package com.laszlobogacsi.entity;

import java.util.ArrayList;
import java.util.List;

public class User {
    private long id;
    private String name;
    private List<Long> followsIdList;

    private User(long id, String name) {
        this.id = id;
        this.name = name;
        this.followsIdList = new ArrayList<>();
    }

    public static User create(long id, String name) {
        return new User(id, name);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Long> getFollowsIdList() {
        return followsIdList;
    }
}
