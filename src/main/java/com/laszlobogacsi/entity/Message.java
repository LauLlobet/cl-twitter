package com.laszlobogacsi.entity;

import java.util.Date;

public class Message {
    private long id;
    private String content;
    private Date createdAt;
    private long userId;

    private Message(long id, String content, long userId) {
        this.id = id;
        this.content = content;
        this.createdAt = new Date(); // create clock provider for testing
        this.userId = userId;
    }

    public static Message create(long id, String content, long userId) {
        return new Message(id, content, userId);
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public long getUserId() {
        return userId;
    }
}
