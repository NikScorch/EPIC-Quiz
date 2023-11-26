package quizgame;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class LoginManager {
    /** Create a new user, save them to disk, return new user */
    public static User registerUser(String username, String password) throws NoSuchAlgorithmException {
        User newUser = new User(username, password);
        saveUser(newUser);
        return newUser;
    }

    /** Check if a user has been saved before */
    public static boolean userExists(String username) {
        File userFile = new File("data/" + username + ".txt");
        if (!userFile.exists()) {
            return false;
        }
        return true;
    }

    /**
     * Get a list of all usernames associated with users saved to disk
     * @return List of usernames
     */
    public static String[] getUsers() {
        File dir = new File("data/");
        File[] files = dir.listFiles();
        List<String> users = new ArrayList<String>();
        for (File file : files) {
            if (!file.getName().endsWith(".txt")) {
                continue;
            }
            users.add(file.getName().replace(".txt", ""));
        }
        return (String[]) users.toArray(new String[users.size()]);
    }

    /** Save a User object to disk */
    public static void saveUser(User user) {
        //user.saveSession();
        try {
            FileOutputStream fout = new FileOutputStream("data/" + user.username + ".txt");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(user);
            oos.close();
            
            System.out.println("session saved");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Load a User from disk
     */
    public static User loadUser(String username) throws NoSuchAlgorithmException {
        User user = null;
        try {
            FileInputStream fin = new FileInputStream("data/" + username + ".txt");
            ObjectInputStream ois = new ObjectInputStream(fin);
            user = (User) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return user;
    }

    /** Retrieve an array of all users */
    public static User[] loadAllUsers() throws NoSuchAlgorithmException {
        String[] usernames = getUsers();
        User[] users = new User[usernames.length];
        for (int i = 0; i < usernames.length; i++) {
            usernames[i] = String.valueOf(loadUser(usernames[i]));
            System.out.println(usernames[i]);
        }
        return users;
    }
}
