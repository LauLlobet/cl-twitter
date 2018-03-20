package com.laszlobogacsi.service;

import com.laszlobogacsi.database.MessageDatabase;
import com.laszlobogacsi.database.UserDatabase;
import com.laszlobogacsi.entity.Message;
import com.laszlobogacsi.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class DatabaseServiceTest {
    private UserDatabase mockUserdb;
    private MessageDatabase mockMessagedb;
    private DatabaseService service;
    private User mockUser;
    private Message mockMessage;
    @BeforeEach
    void setUp() {
        mockUserdb = mock(UserDatabase.class);
        mockMessagedb = mock(MessageDatabase.class);
        mockUser = mock(User.class);
        mockMessage = mock(Message.class);
        service = new DatabaseService(mockUserdb, mockMessagedb);
    }

    @Test
    void can_save_Message_and_user_if_user_not_present() {
        given(mockUserdb.isPresent(any())).willReturn(false);
        given(mockUserdb.addUser(any())).willReturn(true);
        given(mockMessagedb.addMessage(any())).willReturn(true);

        assertTrue(service.save(mockUser, mockMessage));
    }

    @Test
    void can_not_save_a_user_if_already_present() {
        given(mockUserdb.isPresent(any())).willReturn(true);
        service.save(mockUser, mockMessage);
        verify(mockUserdb, times(0)).addUser(mockUser);
        verify(mockMessagedb, times(1)).addMessage(mockMessage);
    }

    @Test
    void can_get_a_user_by_name() {
        given(mockUserdb.getUserByName(any())).willReturn(mockUser);
        given(mockUser.getName()).willReturn("Bob");
        assertEquals(service.getUserByName("Bob"), mockUser);
    }

    @Test
    void can_read_all_messages_of_a_user() {
        List<Message> expected = Arrays.asList(mockMessage, mockMessage);
        given(mockMessagedb.getMessagesBy(any())).willReturn(expected);
        assertEquals(expected, service.readAllMessagesFor("Bob"));
    }

    @Test
    void can_set_follow() {
        given(mockUserdb.getUserByName(any())).willReturn(mockUser);
        given(mockUser.follow(any())).willReturn(true);
        assertTrue(service.setFollow("Alice", "Bob"));
    }

    @Test
    void can_get_wall_for_a_user() {

    }
}