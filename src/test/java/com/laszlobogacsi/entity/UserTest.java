package com.laszlobogacsi.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {

    @Test
    void can_create_user() {
        User alice = User.create(1, "Alice");
        assertEquals(alice.getName(), "Alice");
        assertEquals(alice.getFollowsIdList().size(), 0);
    }

    @Test
    void can_follow() {
        User alice = User.create(1, "Alice");
        User bob = User.create(2, "Bob");
        alice.follow(bob);
        assertEquals(alice.getFollowsIdList().get(0).longValue(), 2L);
    }
}