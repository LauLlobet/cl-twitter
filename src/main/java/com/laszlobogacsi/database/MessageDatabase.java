package com.laszlobogacsi.database;

import com.laszlobogacsi.entity.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementaiton of a simple in memory database represented by an ArrayList
 */
public class MessageDatabase {
    
    private List<Message> messages;
    
    public MessageDatabase() {
        this.messages = new ArrayList<>();
    }

    public boolean addMessage(Message message) {
        return this.messages.add(message);
    }

    public List<Message> getAllMessages() {
        return this.messages;
    }

    public List<Message> getMessagesBy(String userName) {
        return findMessagesBy(userName);
    }

    /**
     * Filters for a user name to return all the messages for the given user name (foreign key)
     * @param userName String user name
     * @return a list of messages
     */
    private List<Message> findMessagesBy(String userName) {
        return this.messages.stream()
                .filter(message -> message.getUserName().equals(userName))
                .collect(Collectors.toList());
    }
}
