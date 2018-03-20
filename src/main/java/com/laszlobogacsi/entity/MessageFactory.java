package com.laszlobogacsi.entity;

import java.time.Clock;
import java.time.LocalDateTime;

/**
 * Creates messages and sets the creation time
 */
public class MessageFactory {
    private Clock clock;

    public MessageFactory(Clock clock) {
        this.clock = clock;
    }

    public Message createMessage(String content,String userName) {
        return new Message(content, userName, LocalDateTime.now(clock));
    }
}
