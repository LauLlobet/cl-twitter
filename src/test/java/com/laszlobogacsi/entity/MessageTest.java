package com.laszlobogacsi.entity;

import com.laszlobogacsi.provider.ClockProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

class MessageTest {
    @BeforeEach
    void setUp() {
        ClockProvider.useFixedClockAt(LocalDateTime.parse("2018-03-15T16:20:35"));
    }

    @Test
    void can_create_message() {
        String content = "Hello World!";
        long userId = 1;
        Message message = Message.create(1, content, userId);

        assertEquals(message.getContent(), "Hello World!");
        assertEquals(message.getUserId(), 1L);
        assertEquals(message.getCreatedAt(), LocalDateTime.parse("2018-03-15T16:20:35"));
    }
}