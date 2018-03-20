package com.laszlobogacsi.util;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Util class for helper methods
 */
public class Utils {

    /**
     * Prints the help instructions to the standard output
     */
    public static void printHelp() {
        System.out.println("Usage:");
        System.out.println("To create a user, post a message.");
        System.out.println("<user name> [command] | <another user name>");
        System.out.println("<user name> -> message                       - post a message");
        System.out.println("<user name>                                  - read timeline messages");
        System.out.println("<user name> follows <another user name>      - follow another user");
        System.out.println("<user name> wall                             - display users wall");
        System.out.println("-help                                        - help");
        System.out.println("exit                                         - exit the program");
    }

    /**
     * Converts a local date time to a human readable format calculated from the elapsed time between now and
     * a given date time.
     * @param clock shared clock instance
     * @param dateTime a given datetime
     * @return a string representation of the elapsed time since a given time.
     */
    public static String humanReadableDate(Clock clock, LocalDateTime dateTime) {
        final int MINUTE = 60;
        final int TWOMINUTES = 2 * 60;
        final int HOUR = 60 * 60;
        final int TWOHOURS = 2 *60 *60;
        final int DAY = 24 * 60 * 60;
        final int TWODAYS = 2 * 24 * 60 * 60;

        final long timeElapsed = dateTime.until(LocalDateTime.now(clock), ChronoUnit.SECONDS);

        if (timeElapsed >= TWODAYS) {
            return timeElapsed / DAY + " days ago";
        }
        if (timeElapsed >= DAY) {
            return "1 day ago";
        }
        if (timeElapsed >= TWOHOURS) {
            return timeElapsed / HOUR + " hours ago";
        }
        if (timeElapsed >= HOUR) {
            return "1 hour ago";
        }
        if (timeElapsed >= TWOMINUTES) {
            return timeElapsed / MINUTE + " minutes ago";
        }
        if (timeElapsed >= MINUTE) {
            return "1 minute ago";
        }
        if (timeElapsed >= 2) {
            return timeElapsed + " seconds ago";
        }
        if (timeElapsed > 0) {
            return "1 second ago";
        }
        return "just now";
    }
}
