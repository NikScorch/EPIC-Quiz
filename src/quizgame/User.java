package quizgame;

import java.util.ArrayList;
import java.util.List;

public class User implements java.io.Serializable {
    String username;
    String password_hash;
    Game data;
    List<Game> pastGames = new ArrayList<Game>();
    Score lifetimeScore = new Score();

    public User(String username, String password) {
        this.username = username;
        this.password_hash = hashPassword(password);
        this.data = new Game();
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
        // Do not accept blank game data *ever*
        if (this.data.questions[0] != null && this.data.questions != null) {
            try {
                this.pastGames.add(this.data.clone());
            } catch (CloneNotSupportedException e) {
                // In theory this code should be unreachable
                // God bless whoever has to debug this if it is ever executed
                System.err.println("Game data is not cloneable, this should not be able to happen");
                e.printStackTrace();
            }
            this.data = new Game();
        }
    }
}
