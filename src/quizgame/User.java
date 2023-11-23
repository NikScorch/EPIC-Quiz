package quizgame;

import java.util.ArrayList;
import java.util.List;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User implements java.io.Serializable {
    String username;
    String password_hash;
    //public Game data;
    //List<Game> pastGames = new ArrayList<Game>();
    //Score lifetimeScore = new Score();

    public static int score =0;


    public User(String username, String password) throws NoSuchAlgorithmException {
        this.username = username;
        this.password_hash = hashPassword(password);
        //this.pastGames.add(new Game());
        //this.data = pastGames.get(pastGames.size() - 1);
        //this.data = new Game();
    }

    /** Check if an entered password matches the stored password */
    public boolean verifyPassword(String enteredPassword) throws NoSuchAlgorithmException {
        System.out.println(enteredPassword);
        return hashPassword(enteredPassword).equals(this.password_hash);
    }

    /** Create a password hash */
    private static String hashPassword(String enteredPassword) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] passwordBytes = enteredPassword.getBytes();
        byte[] hashBytes = digest.digest(passwordBytes);
        StringBuilder sb = new StringBuilder();
        for (byte b : hashBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

//    public void storeQuestion(Question questionToStore) {
//        for (int i = 0; i < data.questions.length; i++) {
//            if (data.questions[i] == null) {
//                data.questions[i] = questionToStore;
//            }
//        }
//    }

//    public void saveSession() {
//        // Save user session and rest session
//        //this.pastGames.add(new Game());
//        //this.data = pastGames.get(pastGames.size() - 1);
//        // this.pastGames.add(this.data);
//        // this.data = new Game();
//
//        if (this.data.questions[0] != null && this.data.questions != null) {
//            try {
//                this.pastGames.add(this.data.clone());
//            } catch (CloneNotSupportedException e) {
//                // In theory this code should be unreachable
//                // God bless whoever has to debug this if it is ever executed
//                System.err.println("Game data is not cloneable, this should not be able to happen");
//                e.printStackTrace();
//            }
//            this.data = new Game();
//        }
//    }

    public int getScore() {
        return score;
    }
    public String getUsername() {
        return username;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println("Entered password: " + "michellePassword \n" +
                "encrypted password : "+ hashPassword("michellePassword"));
    }

}
