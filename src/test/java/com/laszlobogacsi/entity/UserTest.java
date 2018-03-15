package com.laszlobogacsi.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {

    @Test
    void can_create_user() {
        User user = User.create(1, "Alice");
        assertEquals(user.getName(), "Alice");
        assertEquals(user.getFollowsIdList().size(), 0);
    }
}