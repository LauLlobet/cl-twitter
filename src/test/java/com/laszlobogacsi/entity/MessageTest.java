package com.laszlobogacsi.entity;

import com.laszlobogacsi.MessageFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static org.junit.Assert.assertEquals;

class MessageTest {
    private LocalDateTime timeStamp;
    private MessageFactory factory;
    private final LocalDateTime TEST_DATE_TIME = LocalDateTime.of(2018, 3, 15, 16, 20, 35); //2018-03-15 at 16:20:35
    private final ZoneId zoneId = ZoneId.systemDefault();
    private final Clock FIXED_CLOCK = Clock.fixed(TEST_DATE_TIME.atZone(zoneId).toInstant(), zoneId);
    @BeforeEach
    void setUp() {
        timeStamp = LocalDateTime.now(FIXED_CLOCK);
    }

    @Test
    void can_create_message() {
        String content = "Hello World!";
        long userId = 1;
        Message message = new Message(1, content, userId, timeStamp);

        assertEquals(message.getId(), 1L);
        assertEquals(message.getContent(), "Hello World!");
        assertEquals(message.getUserId(), 1L);
        assertEquals(message.getCreatedAt(), LocalDateTime.parse("2018-03-15T16:20:35"));
    }
}