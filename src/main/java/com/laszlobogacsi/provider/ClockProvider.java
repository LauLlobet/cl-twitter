package com.laszlobogacsi.provider;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class ClockProvider {
    private static Clock clock = Clock.systemDefaultZone();
    private static ZoneId zoneId = ZoneId.systemDefault();
    public static LocalDateTime now() {
        return LocalDateTime.now(getClock());
    }

    public static void useFixedClockAt(LocalDateTime date){
        clock = Clock.fixed(date.atZone(zoneId).toInstant(), zoneId);
    }

    private static Clock getClock() {
        return clock;
    }



}
