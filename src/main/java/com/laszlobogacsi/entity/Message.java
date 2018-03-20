package com.laszlobogacsi.entity;

import java.time.LocalDateTime;

/**
 * Message entity, that hold information for the message content the name of the user that created the message and
 * the creation time
 */
public class Message {
    private final String content;
    private final LocalDateTime createdAt;
    private final String userName;

    public Message(String content, String userName, LocalDateTime createdAt) {
        this.content = content;
        this.createdAt = createdAt;
        this.userName = userName;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getUserName() {
        return userName;
    }
}
