package com.laszlobogacsi.database;

import com.laszlobogacsi.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;


class UserDatabaseTest {
    private UserDatabase db = new UserDatabase();
    private User mockUser;

    @BeforeEach
    void setUp() {
        mockUser = mock(User.class);
    }

    @Test
    void has_empty_user_table_on_init() {
        assertEquals(db.getAllUsers().size(), 0);
    }

    @Test
    void can_add_user_to_users_list() {
        db.addUser(mockUser);
        assertEquals(db.getAllUsers().size(), 1);
    }

    @Test
    void can_get_a_user_by_name() {
        db.addUser(mockUser);
        given(mockUser.getName()).willReturn("Bob");

        assertEquals(db.getUserByName("Bob"), mockUser);
    }

    @Test
    void can_tell_if_user_is_present() {
        db.addUser(mockUser);
        given(mockUser.getName()).willReturn("Bob");

        assertTrue(db.isPresent("Bob"));
        assertFalse(db.isPresent("Alice"));
    }
}