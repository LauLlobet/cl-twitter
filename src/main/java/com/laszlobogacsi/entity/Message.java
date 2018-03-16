package com.laszlobogacsi.entity;

import java.time.LocalDateTime;

public class Message {
    private long id;
    private String content;
    private LocalDateTime createdAt;
    private long userId;

    public Message(long id, String content, long userId, LocalDateTime createdAt) {
        this.id = id;
        this.content = content;
        this.createdAt = createdAt;
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public long getUserId() {
        return userId;
    }
}
