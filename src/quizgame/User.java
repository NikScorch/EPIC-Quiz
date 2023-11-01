package quizgame;

import java.util.Scanner;
import java.util.ArrayList;

public class User implements java.io.Serializable {
    String username;
    String password_hash;
    // Establishing variables
    int score = 0;
    int inputedAnswer;
    int mathsScore = 0;
    int compOrgScore = 0;
    int compSciScore = 0;
    int easyScore = 0;
    int mediumScore = 0;
    int hardScore = 0;
    Question[] answeredQuestions = new Question[6];
    Difficulty difficulty = Difficulty.EASY;

    public User(String username, String password) {
        this.username = username;
        this.password_hash = hashPassword(password);
    }

    /** Check if an entered password matches the stored password */
    public boolean verifyPassword(String enteredPassword) {
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
        for (int i = 0; i < answeredQuestions.length; i++) {
            if (answeredQuestions[i] == null) {
                answeredQuestions[i] = questionToStore;
            }
        }
    }

    public static void main(String[] args) {

    }

    // calculating the overall score of the test
    public int score(Question q) {
        for (int i = 0; i <= 6; i++) {

            if (inputedAnswer == q.answerIndex) {
                System.out.println("Correct answer!");
                score++;
            } else {
                System.out.println("Incorrect answer!");
            }

        }

        return score;
    }


    // calculating the score for maths specifically
    public int scoreForDiscreteMaths() {
        for (Question q : answeredQuestions) {
            // If the given question is NOT a discrete maths question
            // Skip the question, and try another one
            if (q.topic != Topic.DISCRETE_MATHS) {
                continue;
            }
            // If it is a discrete maths Q, increase the maths score
            mathsScore++;
        }
        return mathsScore;
    }

    // calculating the score for comp Org specifically
    public int scoreForCompOrg() {
        for (Question q : answeredQuestions) {
            if (q.topic != Topic.COMP_ORG) {
                continue;
            }
            compOrgScore++;
        }
        return compOrgScore;
    }


    // calculating the score for cs spcifically
    public int scoreForCompScicence() {
        for (Question q : answeredQuestions) {
            if (q.topic != Topic.COMPUTER_SCIENCE) {
                continue;
            }
            compSciScore++;
        }
        return compSciScore;
    }

    // calculating the score for easy questions
    public int scoreForEasy() {
        for (Question q : answeredQuestions) {
            if (q.difficulty != Difficulty.EASY) {
                continue;
            }
            easyScore++;
        }
        return easyScore;

    }

    // calcualting the score for medium questions
    public int scoreForMedium() {
        for (Question q : answeredQuestions) {
            if (q.difficulty != Difficulty.MEDIUM) {
                continue;
            }
            mediumScore++;
        }
        return mediumScore;
    }

    // calcualting the score for hard questions
    public int scoreForHard() {
        for (Question q : answeredQuestions) {
            if (q.difficulty != Difficulty.HARD) {
                continue;
            }
            hardScore++;
        }
        return hardScore;
    }

}
