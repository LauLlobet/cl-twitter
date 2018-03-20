package com.laszlobogacsi.database;

import com.laszlobogacsi.entity.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class MessageDatabaseTest {
    private MessageDatabase db = new MessageDatabase();
    private Message mockMessage;

    @BeforeEach
    void setUp() {
        mockMessage = mock(Message.class);
    }

    @Test
    void has_empty_message_table_on_init() {
        assertEquals(db.getAllMessages().size(), 0);
    }

    @Test
    void can_add_message_to_message_list() {
        db.addMessage(mockMessage);
        assertEquals(db.getAllMessages().size(), 1);
    }

    @Test
    void can_get_a_message_by_userName() {
        db.addMessage(mockMessage);
        given(mockMessage.getUserName()).willReturn("Bob");

        assertEquals(db.getMessagesBy("Bob").get(0), mockMessage);
    }
}