package com.laszlobogacsi.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MessageTest {
    @Test
    void can_create_message() {
        String content = "Hello World!";
        long userId = 1;
        Message message = Message.create(1, content, userId);

        assertEquals(message.getContent(), "Hello World!");
        assertEquals(message.getUserId(), 1L);
    }
}