package com.laszlobogacsi.handler;

import com.laszlobogacsi.ClTwitter;
import com.laszlobogacsi.entity.Message;
import com.laszlobogacsi.provider.ClockProvider;

import java.time.Clock;
import java.util.Comparator;
import java.util.List;

import static com.laszlobogacsi.util.Utils.humanReadableDate;
import static com.laszlobogacsi.util.Utils.printHelp;

/**
 * Inputhandler handles the commandline inputs and delegates them to the appropriate public twitter api.
 */
public class InputHandler {
    private static Clock clock = ClockProvider.getInstance().getClock();
    public static void inputHandler(ClTwitter twitter, String input) { //SMELL: SRP, needs collaborator to extract commands , no console
        // post
        if (input.contains("->")) {
            String[] commands = input.split("\\s+->\\s+");
            twitter.post(commands[0], commands[1]);
        }
        // read, sorts the messages by the creation date in reverse order (latest first)
        if (!input.contains(" ")) {
            List<Message> timeline = twitter.read(input);
            timeline.sort(Comparator.comparing(Message::getCreatedAt).reversed());
            timeline.forEach(message ->
                    System.out.println(message.getUserName() + " - " + message.getContent() + " (" + humanReadableDate(clock, message.getCreatedAt()) + ")"));
        }
        // follow
        if (input.contains("follows")) {
            String[] commands = input.split("\\s+follows\\s+");
            twitter.follow(commands[0], commands[1]);
        }
        // wall, sorts the messages by the creation date in reverse order (latest first)
        if (input.contains("wall")) {
            String userName = input.replaceAll("\\s+wall", "");
            List<Message> messages = twitter.wall(userName);
            messages.sort(Comparator.comparing(Message::getCreatedAt).reversed());
            messages.forEach(message ->
                    System.out.println(message.getUserName() + " - " + message.getContent() + " (" + humanReadableDate(clock, message.getCreatedAt()) + ")"));
        }
        // print help
        if (input.contains("-help")) {
            printHelp();
        }
        // exit the program
        if (input.contains("exit")) {
            System.exit(0);
        }
    }
}
