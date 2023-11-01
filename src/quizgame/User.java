package quizgame;

import java.util.ArrayList;
import java.util.List;

public class User implements java.io.Serializable {
    String username;
    String password_hash;
    Game data;
    List<Game> pastGames = new ArrayList<Game>();
    Score lifetimeScore = new Score();
    //Difficulty difficulty = Difficulty.EASY;

    public User(String username, String password) {
        this.username = username;
        this.password_hash = hashPassword(password);
        this.pastGames.add(new Game());
        this.data = pastGames.get(pastGames.size() - 1);
    }

    /** Check if an entered password matches the stored password */
    public boolean verifyPassword(String enteredPassword) {
        System.out.println(enteredPassword);
        return hashPassword(enteredPassword).equals(this.password_hash);
    }

    /** Create a password hash */
    private String hashPassword(String enteredPassword) {
        // TODO: should realistically have a better hashing alorithm
        // This is a placehold so all code calling to hash passwords
        // points to the same place
        return Integer.toString(enteredPassword.hashCode());
    }

    public void storeQuestion(Question questionToStore) {
        for (int i = 0; i < data.questions.length; i++) {
            if (data.questions[i] == null) {
                data.questions[i] = questionToStore;
            }
        }
    }

    public void saveSession() {
        // Save user session and rest session
        this.pastGames.add(new Game());
        this.data = pastGames.get(pastGames.size() - 1);
        // this.pastGames.add(this.data);
        // this.data = new Game();
    }

}
