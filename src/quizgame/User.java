package quizgame;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User implements java.io.Serializable {
    String username;
    String password_hash;

    public static int score =0;

    public User(String username, String password) throws NoSuchAlgorithmException {
        this.username = username;
        this.password_hash = hashPassword(password);
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
