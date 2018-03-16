package com.laszlobogacsi;

import com.laszlobogacsi.entity.Message;

import java.time.Clock;
import java.time.LocalDateTime;

public class MessageFactory {
    private Clock clock;

    public MessageFactory(Clock clock) {
        this.clock = clock;
    }

    public Message createMessage(long id, String content,long userId) {
        return new Message(id, content, userId, LocalDateTime.now(clock));
    }
}
