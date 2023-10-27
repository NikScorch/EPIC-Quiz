package quizgame;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class LoginManager {
    /** Create a new user, save them to disk, return new user */
    public static User registerUser(String username, String password) {
        User newUser = new User(username, password);
        saveUser(newUser);
        return newUser;
    }

    /** Check if a user has been saved before */
    public static boolean userExists(String username) {
        File userFile = new File("data1/user_" + username + ".csv");
        if (!userFile.exists()) {
            return false;
        }
        return true;
    }

    /** Save a User object to disk */
    public static void saveUser(User user) {
        // serialize the Queue
        System.out.println("serializing theQueue");
        try {
            FileOutputStream fout = new FileOutputStream("data/user_" + user.username + ".bin");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(user);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /** Load a User from disk */
    public static User loadUser(String username) {
        User user;
        try {
            FileInputStream fin = new FileInputStream("data/user_" + username + ".bin");
            ObjectInputStream ois = new ObjectInputStream(fin);
            user = (User) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
            return new User(null, null);
        }
        return user;
    }

    // Testing purposes only
    public static void main(String[] args) {
        new LoginManager();
        User a = new User("debug", "debug_password");
        LoginManager.saveUser(a);
        User b = LoginManager.loadUser("debug");
        System.out.println(b.username);
        System.out.println(b.password_hash);
    }
}
