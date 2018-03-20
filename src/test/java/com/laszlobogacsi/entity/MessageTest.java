package com.laszlobogacsi.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MessageTest {
    private LocalDateTime timeStamp;
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
        String userName = "Alice";
        Message message = new Message(content, userName, timeStamp);

        assertEquals(message.getContent(), "Hello World!");
        assertEquals(message.getUserName(), "Alice");
        assertEquals(message.getCreatedAt(), LocalDateTime.parse("2018-03-15T16:20:35"));
    }
}