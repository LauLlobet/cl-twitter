# CL Twitter
##### The command line based social networking application

### Objective

- To implement a console-based social networking application (similar to Twitter)
- Create basic features: Posting, Reading, Following.
- use the console for input and output

### System requirements

- Java8
- Gradle 4.x

### How to run

- clone
- cd cl-twitter
- `gradle test`
- `java -jar cltwitter-1.0.jar`
- `-help` for list of commands

### Usage

- posting: `<user_name> -> <message>` to post a message to personal timeline: e.g.: `Bob -> Hello World!`
- reading: `<user_name>` to read the personal timeline e.g.: `Bob` `Hello World! (5 seconds ago)`
- following: `<user_name> follows <another_user_name>` to follow another user, e.g.: `Bob follow Alice`
- wall: `<user_name> wall` to read an aggregated list of personal timeline and followed users timelines,   
    e.g.: `Bob wall`   
            `Bob - Hello World! (5 seconds ago)`  
            `Alice - Hello CL Twitter (14 minutes ago)`
            

### Rules / requirements:

- User will always type the correct commands
- No error handling necessary
- Working locally only (no networking functionality)
- All users will use the same terminal.
- Non existing users will be created at their first message
- Application starts with an empty list of users
- User name must be unique
- Displays the list of messages sorted by creation time in reversed order
- Prints a human readable data displaying the elapsed time between now and the time of message creation
