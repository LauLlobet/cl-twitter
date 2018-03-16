package com.laszlobogacsi.database;

import com.laszlobogacsi.entity.Message;

import java.util.ArrayList;
import java.util.List;

public class MessageDatabase {
    
    private List<Message> messages;
    
    public MessageDatabase() {
        this.messages = new ArrayList<>();
    }

    public void addMessage(Message user) {
        this.messages.add(user);
    }

    public List<Message> getAllMessages() {
        return this.messages;
    }

    public Message getMessageById(long id) {
        return findMessageBy(id);
    }


    private Message findMessageBy(long id) {
        return this.messages.stream()
                .filter(message -> message.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
