package com.laszlobogacsi.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {

    @Test
    void can_create_user() {
        User alice = new User("Alice");
        assertEquals(alice.getName(), "Alice");
        assertEquals(alice.getFollowsNameList().size(), 0);
    }

    @Test
    void can_follow_one_user() {
        User alice = new User( "Alice");
        User bob = new User("Bob");
        alice.follow(bob.getName());
        assertEquals(alice.getFollowsNameList().get(0), "Bob");
    }

    @Test
    void can_follow_multiple_users() {
        User alice = new User( "Alice");
        User bob = new User("Bob");
        User charlie = new User("Charlie");
        alice.follow(bob.getName());
        alice.follow(charlie.getName());
        assertEquals(alice.getFollowsNameList().size(), 2);
        assertEquals(alice.getFollowsNameList().get(1), "Charlie");
    }
}