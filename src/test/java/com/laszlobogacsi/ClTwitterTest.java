package com.laszlobogacsi;

import com.laszlobogacsi.entity.Message;
import com.laszlobogacsi.service.DatabaseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class ClTwitterTest {
    private ClTwitter twitter;
    private Message mockMessage;
    private DatabaseService db;

    @BeforeEach
    void setUp() {
        db = mock(DatabaseService.class);
        twitter = new ClTwitter(db);
        mockMessage = mock(Message.class);
    }

    @Test
    void can_post_a_message() {
        twitter.post("Bob", "Hello World!");
        verify(db, times(1)).save(any(), any());
    }

    @Test
    void can_read_users_timeline_empty_by_default() { // SMELL: is it a baheviour test or a aceptance test of the whole app
        List<Message> expected = new ArrayList<>();
        List<Message> response = twitter.read("Bob");
        assertEquals(expected, response);
    }

    @Test
    void can_read_users_timeline() {
        List<Message> expected = Arrays.asList(mockMessage);
        given(db.readAllMessagesFor(any())).willReturn(expected);
        assertEquals(expected, twitter.read("Bob"));
    }

    @Test
    void can_follow_another_user() {
        given(db.setFollow(any(), any())).willReturn(true);
        assertTrue(twitter.follow("Alice", "Bob"));
    }

    @Test
    void can_read_users_wall() {
        List<Message> expected = Arrays.asList(mockMessage, mockMessage);
        given(db.getWallFor(any())).willReturn(expected);
        assertEquals(twitter.wall("Alice"), expected);

    }
}