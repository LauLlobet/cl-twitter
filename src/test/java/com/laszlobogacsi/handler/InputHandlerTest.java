package com.laszlobogacsi.handler;

import com.laszlobogacsi.ClTwitter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class InputHandlerTest {
    private ClTwitter mockTwitter;

    @BeforeEach
    void setUp() {
        mockTwitter = mock(ClTwitter.class);
    }

    @Test
    void can_handle_post() {
        InputHandler.inputHandler(mockTwitter, "Bob -> Hello World!");
        verify(mockTwitter).post("Bob", "Hello World!");
    }

    @Test
    void can_handle_read() {
        InputHandler.inputHandler(mockTwitter, "Bob");
        verify(mockTwitter).read("Bob");
    }

    @Test
    void can_handle_follows() {
        InputHandler.inputHandler(mockTwitter, "Bob follows Charlie");
        verify(mockTwitter).follow("Bob", "Charlie");
    }

    @Test
    void can_handle_wall() {
        InputHandler.inputHandler(mockTwitter, "Bob wall");
        verify(mockTwitter).wall("Bob");
    }
}