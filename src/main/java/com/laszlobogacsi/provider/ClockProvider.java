package com.laszlobogacsi.provider;

import java.time.Clock;

/**
 * Clockprovider provides a singleton instance of a clock that can be used throughout the program
 */
public class ClockProvider {
    private static Clock clock = Clock.systemDefaultZone();

    private static ClockProvider instance;

    private ClockProvider() { }

    public static ClockProvider getInstance() {
        if(instance == null) {
            instance = new ClockProvider();
        }
        return instance;
    }

    public Clock getClock() {
        return clock;
    }

}
