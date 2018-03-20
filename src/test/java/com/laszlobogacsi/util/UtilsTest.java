package com.laszlobogacsi.util;

import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UtilsTest {
    private final LocalDateTime TEST_DATE_TIME = LocalDateTime.of(2018, 3, 15, 16, 20, 35); //2018-03-15 at 16:20:35
    private final ZoneId zoneId = ZoneId.systemDefault();
    private final Clock FIXED_CLOCK = Clock.fixed(TEST_DATE_TIME.atZone(zoneId).toInstant(), zoneId);
    private final LocalDateTime NOW = LocalDateTime.now(FIXED_CLOCK);

    @Test
    void can_return_human_readable_date_for_1_sec() {
        LocalDateTime time = TEST_DATE_TIME.minusSeconds(1);
        String readableDate = Utils.humanReadableDate(FIXED_CLOCK, time);
        assertEquals("1 second ago", readableDate);
    }

    @Test
    void can_return_human_readable_date_for_2_seconds() {
        LocalDateTime time = TEST_DATE_TIME.minusSeconds(2);
        String readableDate = Utils.humanReadableDate(FIXED_CLOCK, time);
        assertEquals("2 seconds ago", readableDate);
    }

    @Test
    void can_return_human_readable_date_for_1_minute() {
        LocalDateTime time = TEST_DATE_TIME.minusMinutes(1);
        String readableDate = Utils.humanReadableDate(FIXED_CLOCK, time);
        assertEquals("1 minute ago", readableDate);
    }

    @Test
    void can_return_human_readable_date_for_2_minutes() {
        LocalDateTime time = TEST_DATE_TIME.minusMinutes(2);
        String readableDate = Utils.humanReadableDate(FIXED_CLOCK, time);
        assertEquals("2 minutes ago", readableDate);
    }

    @Test
    void can_return_human_readable_date_for_1_hour() {
        LocalDateTime time = TEST_DATE_TIME.minusHours(1);
        String readableDate = Utils.humanReadableDate(FIXED_CLOCK, time);
        assertEquals("1 hour ago", readableDate);
    }

    @Test
    void can_return_human_readable_date_for_2_hours() {
        LocalDateTime time = TEST_DATE_TIME.minusHours(2);
        String readableDate = Utils.humanReadableDate(FIXED_CLOCK, time);
        assertEquals("2 hours ago", readableDate);
    }

    @Test
    void can_return_human_readable_date_for_1_day() {
        LocalDateTime time = TEST_DATE_TIME.minusDays(1);
        String readableDate = Utils.humanReadableDate(FIXED_CLOCK, time);
        assertEquals("1 day ago", readableDate);
    }

    @Test
    void can_return_human_readable_date_for_2_days() {
        LocalDateTime time = TEST_DATE_TIME.minusDays(2);
        String readableDate = Utils.humanReadableDate(FIXED_CLOCK, time);
        assertEquals("2 days ago", readableDate);
    }
}