package com.laszlobogacsi;

import com.laszlobogacsi.database.MessageDatabase;
import com.laszlobogacsi.database.UserDatabase;
import com.laszlobogacsi.service.DatabaseService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.laszlobogacsi.handler.InputHandler.inputHandler;

/**
 * Main class to try the console based twitter from the command line
 */
public class Main {

    private static ClTwitter twitter = new ClTwitter(new DatabaseService(new UserDatabase(), new MessageDatabase()));

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to Command Line Twitter");
        System.out.println("For help: -help");
        System.out.println("Post a message:");

        while(true) {
            String input = null;
            try {
                input = reader.readLine();
                inputHandler(twitter, input);
            } catch (IOException e) {
                // ignore error
            }
        }
    }
}
