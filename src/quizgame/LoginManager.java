package quizgame;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class LoginManager {
    // do we even need this?
    /*
    public LoginManager(String username, String password) {
        File userFile = new File("data/user_" + username + ".dat");

        // Make sure parent directory exists
        File parentDir = userFile.getParentFile();
        if (!parentDir.exists()) {
            parentDir.mkdirs();
        }

        // Check for file present
        if (!userFile.exists()) {
            try {
                // userFile.mkdirs();
                userFile.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    } */

    // public static User registerUser(String username, String password) {

    // }

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
        }
        catch (Exception e) { e.printStackTrace(); }
    }

    /** Load a User from disk */
    public static User loadUser(String username) {
        User user = new User(username, username);
        try {
            FileInputStream fin = new FileInputStream("data/user_" + username + ".dat");
            ObjectInputStream ois = new ObjectInputStream(fin);
            user = (User) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;

    }


    // Testing purposes only
    public static void main(String[] args) {
        new LoginManager();
        User a = new User("nik", "nikpass");
        LoginManager.saveUser(a);
        User b = LoginManager.loadUser("nik");
    }
}
