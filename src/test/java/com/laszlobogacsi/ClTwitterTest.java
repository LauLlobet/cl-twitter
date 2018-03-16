package com.laszlobogacsi;

import com.laszlobogacsi.entity.Message;
import com.laszlobogacsi.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

class ClTwitterTest {
    private ClTwitter twitter;
    private User mockUser;
    private Message mockMessage;

    @BeforeEach
    void setUp() {
        twitter = new ClTwitter();
        mockUser = mock(User.class);
        mockMessage = mock(Message.class);
    }

    @Test
    void can_post_a_message() {
        assertTrue(twitter.post(mockUser, mockMessage));
    }
}