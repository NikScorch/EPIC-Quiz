package quizgame;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoginManager {
    /** Create a new user, save them to disk, return new user */
    public static User registerUser(String username, String password) {
        User newUser = new User(username, password);
        saveUser(newUser);
        return newUser;
    }

    /** Check if a user has been saved before */
    public static boolean userExists(String username) {
        File userFile = new File("data/" + username + ".user");
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
            if (!file.getName().endsWith(".user")) {
                continue;
            }
            users.add(file.getName().replace(".user", ""));
        }
        return (String[]) users.toArray(new String[users.size()]);
    }

    /** Save a User object to disk */
    public static void saveUser(User user) {
        user.saveSession();
        try {
            FileOutputStream fout = new FileOutputStream("data/" + user.username + ".user");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(user);
            oos.close();
            
            System.out.println("session saved");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /** Load a User from disk */
    public static User loadUser(String username) {
        User user;
        try {
            FileInputStream fin = new FileInputStream("data/" + username + ".user");
            ObjectInputStream ois = new ObjectInputStream(fin);
            user = (User) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
            user = new User(null, null);
        }
        return user;
    }

    /** Retrieve an array of all users */
    public static User[] loadAllUsers() {
        String[] usernames = getUsers();
        User[] users = new User[usernames.length];
        for (int i = 0; i < usernames.length; i++) {
            users[i] = loadUser(usernames[i]);
        }
        return users;
    }

    // Testing purposes only
    public static void main(String[] args) {
        new LoginManager();
        User a = new User("debug", "debug_password");
        LoginManager.saveUser(a);
        User b = LoginManager.loadUser("debug");
        System.out.println(b.username);
        System.out.println(b.password_hash);
        System.out.println(Arrays.toString(getUsers()));
        User[] users = loadAllUsers();
        for (User user: users) {
            System.out.println(user.username + "\t" + user.password_hash);
        }
        Game eA = new Game();
        Game eB = new Game();
        System.out.println(eA.equals(eB));
    }
}
