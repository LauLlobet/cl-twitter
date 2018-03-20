package com.laszlobogacsi;

import com.laszlobogacsi.entity.Message;
import com.laszlobogacsi.entity.MessageFactory;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MessageFactoryTest {
    private final LocalDateTime TEST_DATE_TIME = LocalDateTime.of(2018, 3, 15, 16, 20, 35); //2018-03-15 at 16:20:35
    private final ZoneId zoneId = ZoneId.systemDefault();
    private final Clock FIXED_CLOCK = Clock.fixed(TEST_DATE_TIME.atZone(zoneId).toInstant(), zoneId);
    private final LocalDateTime NOW = LocalDateTime.now(FIXED_CLOCK);

    @Test
    void factory_can_create_message() {
        MessageFactory factory = new MessageFactory(FIXED_CLOCK);
        Message message = factory.createMessage("Hello World!", "Bob");
        assertEquals(message.getCreatedAt(), NOW);
    }
}