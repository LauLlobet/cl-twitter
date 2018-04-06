package com.laszlobogacsi;

import com.laszlobogacsi.entity.Message;
import com.laszlobogacsi.entity.MessageFactory;
import com.laszlobogacsi.entity.User;
import com.laszlobogacsi.provider.ClockProvider;
import com.laszlobogacsi.service.DatabaseService;

import java.util.List;

/**
 * ClTwitter holds the public api of the program implementing all the features
 */
public class ClTwitter {
    private final DatabaseService dbService; // Reference for the database service
    private final ClockProvider clockProvider = ClockProvider.getInstance(); // reference for a clockprovider
    private final MessageFactory messageFactory = new MessageFactory(clockProvider.getClock()); // factory class for messages

    /**
     * Constructor with injected database service
     * @param dbService instance that delegates towards other databases
     */
    public ClTwitter(DatabaseService dbService) {               //SMELL: it looks like a man in the middle
        this.dbService = dbService;
    }

    /**
     * Post feature, to post a message on a users timeline
     * If user doesn't exist will create on first post.
     * @param userName String name of the user
     * @param messageContent String message to post on timeline
     */
    public void post(String userName, String messageContent) {
        Message message = messageFactory.createMessage(messageContent, userName);
        if(!dbService.isExist(userName)) {                          // SMELL: single point of truth this if is present in save as well
            dbService.save(new User(userName), message);            // SMELL: CLI responsability class doing bussines logic SRP,
            // SMELL: user and message usually go together, data clump. Looks like repository mapped to bussines logic
        } else {                                                    // SMELL: use of else
            dbService.save(dbService.getUserByName(userName), message);
        }
    }

    /**
     * Read feature, read all the message for the given user name
     * @param userName String user name
     * @return List of messages for a given user, empty list if no messages present
     */
    public List<Message> read(String userName) {
        return dbService.readAllMessagesFor(userName);
    }

    /**
     * Follow feature, so one user can follow another user
     * @param userName String user name that wants to follow someone else
     * @param anotherUserName String user name, the on ewho will be followed
     * @return boolean true if follow is successful, false otherwise
     */
    public boolean follow(String userName, String anotherUserName) {
        return dbService.setFollow(userName, anotherUserName);
    }

    /**
     * Wall feature, to list all the messages for a given user from the user itself and all the other followed users
     * messages as well
     * @param userName String user name
     * @return a list of messages that are on the wall of a given user, including the followed users total messages
     */
    public List<Message> wall(String userName) {
        return dbService.getWallFor(userName);
    }
}
