package com.laszlobogacsi.service;

import com.laszlobogacsi.database.MessageDatabase;
import com.laszlobogacsi.database.UserDatabase;
import com.laszlobogacsi.entity.Message;
import com.laszlobogacsi.entity.User;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Database service, a service layer between the database implementation and the rest of the program
 * Delegates the calls to the right database
 */
public class DatabaseService {
    private UserDatabase userDatabase;
    private MessageDatabase messageDatabase;

    /**
     * Constuctor, dependent on the two injected database instances
     * @param userDatabase instance of users database implementation
     * @param messageDatabase instance of messages database implemetation
     */
    public DatabaseService(UserDatabase userDatabase, MessageDatabase messageDatabase) {
        this.userDatabase = userDatabase;
        this.messageDatabase = messageDatabase;
    }

    /**
     * Saves the user to the user database if user not already present and saves the message to the message database
     * @param user User object
     * @param message Message object
     * @return boolean true if save is successful
     */
    public boolean save(User user, Message message){
        if(!isExist(user.getName())) {
            return messageDatabase.addMessage(message) && userDatabase.addUser(user);
        }
        return messageDatabase.addMessage(message);
    }

    /**
     * Checks if the user is present in the user database or not.
     * @param userName User
     * @return boolean true if user exists in database
     */
    public boolean isExist(String userName) {
        return userDatabase.isPresent(userName);
    }

    /**
     * Fetches the user from the database by name
     * @param userName String user name
     * @return the User object if present in data base, null if user not exists.
     */
    public User getUserByName(String userName) {
        return userDatabase.getUserByName(userName);
    }

    /**
     * Fetches all the messages for a given user
     * @param userName Strign user name
     * @return a list of messages for a given user, empty list when there is none.
     */
    public List<Message> readAllMessagesFor(String userName) {
        return messageDatabase.getMessagesBy(userName);
    }

    /**
     * Set the followed users name for a given user
     * @param userName String user name that want to follow another one
     * @param followedUserName String name of the user that will be followed
     * @return boolean true if the follow is successful
     */
    public boolean setFollow(String userName, String followedUserName) {
        return userDatabase.getUserByName(userName).follow(followedUserName);
    }

    /**
     * Fetches all the messages for a given user from the users wall
     * @param userName String user name
     * @return a list of message for a given user including all the followed users messages
     */
    public List<Message> getWallFor(String userName) {
        User user = getUserByName(userName);
        List<String> listOfFollowedUsers = user.getFollowsNameList();
        listOfFollowedUsers.add(userName);

        return listOfFollowedUsers.stream()
                .map(this::readAllMessagesFor)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
