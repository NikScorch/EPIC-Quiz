package quizgame;

public class Game implements java.io.Serializable {
    // go fuck yourself ISE
    int inputedAnswer;
    int score = 0;
    int mathsScore = 0;
    int compOrgScore = 0;
    int compSciScore = 0;
    int easyScore = 0;
    int mediumScore = 0;
    int hardScore = 0;
    Question[] questions = new Question[6];
    

    // // calculating the overall score of the test
    // public int score(Question q) {
    //     for (int i = 0; i <= 6; i++) {

    //         if (inputedAnswer == q.answerIndex) {
    //             System.out.println("Correct answer!");
    //             score++;
    //         } else {
    //             System.out.println("Incorrect answer!");
    //         }

    //     }

    //     return score;
    // }


    // // calculating the score for maths specifically
    // public int scoreForDiscreteMaths() {
    //     for (Question q : answeredQuestions) {
    //         // If the given question is NOT a discrete maths question
    //         // Skip the question, and try another one
    //         if (q.topic != Topic.DISCRETE_MATHS) {
    //             continue;
    //         }
    //         // If it is a discrete maths Q, increase the maths score
    //         mathsScore++;
    //     }
    //     return mathsScore;
    // }

    // // calculating the score for comp Org specifically
    // public int scoreForCompOrg() {
    //     for (Question q : answeredQuestions) {
    //         if (q.topic != Topic.COMP_ORG) {
    //             continue;
    //         }
    //         compOrgScore++;
    //     }
    //     return compOrgScore;
    // }


    // // calculating the score for cs spcifically
    // public int scoreForCompScicence() {
    //     for (Question q : answeredQuestions) {
    //         if (q.topic != Topic.COMPUTER_SCIENCE) {
    //             continue;
    //         }
    //         compSciScore++;
    //     }
    //     return compSciScore;
    // }

    // // calculating the score for easy questions
    // public int scoreForEasy() {
    //     for (Question q : answeredQuestions) {
    //         if (q.difficulty != Difficulty.EASY) {
    //             continue;
    //         }
    //         easyScore++;
    //     }
    //     return easyScore;

    // }

    // // calcualting the score for medium questions
    // public int scoreForMedium() {
    //     for (Question q : answeredQuestions) {
    //         if (q.difficulty != Difficulty.MEDIUM) {
    //             continue;
    //         }
    //         mediumScore++;
    //     }
    //     return mediumScore;
    // }

    // // calcualting the score for hard questions
    // public int scoreForHard() {
    //     for (Question q : answeredQuestions) {
    //         if (q.difficulty != Difficulty.HARD) {
    //             continue;
    //         }
    //         hardScore++;
    //     }
    //     return hardScore;
    // }
}
