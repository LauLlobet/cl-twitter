package com.laszlobogacsi.provider;

import java.time.Clock;

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
