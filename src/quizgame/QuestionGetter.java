package quizgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class QuestionGetter {
    /*
     * Make an array of Question classes
     * This is our Question bank, it looks horrendous but it will have to do
     * When defining a new entry, the format is as follows:
     * new Question("How many legs does a dog have?", 
     *               new String[]{"2","4","7","5"}, 1, 
     *               Topic.COMP_ORG, Difficulty.EASY),
     */
    public static Question[] questions;

    public static void loadQuestions() {
        loadQuestions("data/questions.csv");
    }
    public static void loadQuestions(String fileName) {
        Scanner file;
        // Bad code that attempts to find which file we are editing
        try {
            file = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            try {
                file = new Scanner(new File("data/questions.csv"));
            } catch (FileNotFoundException e1) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                e1.printStackTrace();
                return;
            }
        }
        file.useDelimiter(",");
        /*
         * I have spent seven days trying to make this work but no matter what i do, csv has decidede i should go fuck myself
         * please explain why scanner is unable to split at both line ends and semicolons
         */
        for (int i = 0; i < 8; i++) {
            file.next();        // Remove file header
        }
        List<Question> data = new ArrayList<Question>();

        while (file.hasNext()) {
            // This disgusting line converts each line in the csv file into question classes
            data.add(new Question(
                file.next().substring(1), 
                new String[]{
                    file.next(), 
                    file.next(), 
                    file.next(), 
                    file.next()
                }, 
                Integer.parseInt(file.next()), 
                Topic.values()[Integer.parseInt(file.next())], 
                Difficulty.values()[Integer.parseInt(file.next())])
            );
        }
        questions = data.toArray(new Question[data.size()]);
    }

    /**
     * Retrieve an array of all available questions
     * @return Question array of all loaded questions
     */
    public static Question[] getAllQuestions() {
        return questions;
    }

    /**
     * Get all questions that match the given parameters
     * @param difficulty Find all questions that match the given difficulty
     * @return Array of Question objects from the question bank
     */
    public static Question[] getAllQuestionsByFilter(Topic topic) {
        return getAllQuestionsByFilter(topic, null);
    }
    /**
     * Get all questions that match the given parameters
     * @param difficulty Find all questions that match the given difficulty
     * @return Array of Question objects from the question bank
     */
    public static Question[] getAllQuestionsByFilter(Difficulty difficulty) {
        return getAllQuestionsByFilter(null, difficulty);
    }
    /**
     * Get all questions that match the given parameters
     * @param topic Find all questions that match the given subject
     * @param difficulty Filter for only a specific difficulty of those subject questions
     * @return Array of Question objects from the question bank
     */
    public static Question[] getAllQuestionsByFilter(Topic topic, Difficulty difficulty) {
        List<Question> filteredQuestions = new ArrayList<Question>();
        for (Question q: questions) {
            if ((q.topic == topic || topic == null) && (q.difficulty == difficulty || difficulty == null)) {
                filteredQuestions.add(q);
            }
        }
        // Convert ArrayList to Array
        Question[] filteredQuestionsArray = filteredQuestions.toArray(new Question[filteredQuestions.size()]);
        return filteredQuestionsArray;
    }

    /**
     * Get single random question from the entire question bank
     * @return
     */
    public static Question getRandomQuestion() {
        return questions[(int) (Math.random() * questions.length)];
    }

    /**
     * Method filters and returns all questions within given topic
     * @param topic Subject enum to filter by
     * @return Returns a random Question given a filter
     */
    public static Question getRandomQuestionByFilter(Topic topic) {
        return getRandomQuestionByFilter(topic, null);
    }
    /**
     * Method filters and returns all questions within given difficulty 
     * @param difficulty Difficulty enum to filter by
     * @return Returns a random Question given a filter
     */
    public static Question getRandomQuestionByFilter(Difficulty difficulty) {
        return getRandomQuestionByFilter(null, difficulty);
    }
    /**
     * Method filters and returns all questions within given requirements
     * @param topic Subject enum to filter by
     * @param difficulty Difficulty enum to filter by
     * @return Returns a random Question given a filter
     */
    public static Question getRandomQuestionByFilter(Topic topic, Difficulty difficulty) {
        Question[] filterQuestions = getAllQuestionsByFilter(topic, difficulty);
        return filterQuestions[(int) (Math.random() * (filterQuestions.length + 1))];
    }

    // This main function should never be run in production
    // It is for debug purposes only
    public static void main(String[] args) {
        //specific_subject_random_game(Topic.COMPUTER_SCIENCE);
        // getRandomQuestion();

        // Question q = new Question("How many legs does a dog have?", new String[]{"2","4","7","5"}, 1, Topic.COMP_ORG, Difficulty.EASY);
        // q.print();

        // Question[] qs = getAllQuestionsByFilter(Topic.COMPUTER_SCIENCE);
        // System.out.println(java.util.Arrays.toString(qs));
        // System.out.println(qs.length);
        loadQuestions();
        for (Question q: questions) {
            q.print();
        }


    }

}

/**
 * Stores all relavant data regarding a question in a single object
 */
class Question {
    String question;
    String[] answers;
    int answerIndex;
    Topic topic;
    Difficulty difficulty;

    /**
     * @param question Question given to the user
     * @param answers All multiple choice answers to the given question
     * @param correctAnswerIndex The position of the correct answer in the previous argument
     * @param topic The topic the question fits into
     */
    public Question(String question, String[] answers, int correctAnswerIndex, Topic topic, Difficulty difficulty) {
        this.question = question;
        this.answers = answers;
        this.answerIndex = correctAnswerIndex;
        this.topic = topic;
        this.difficulty = difficulty;
    }

    public void print() {
        System.out.println(this.question + "\t\t" + this.answers[this.answerIndex] + "\t\tTopic " + this.topic + "\t\tDifficulty " + this.difficulty);
    }
}

/** Indicator for the topic of a question */
enum Topic {
    DISCRETE_MATHS,
    COMP_ORG,
    COMPUTER_SCIENCE
}

/** Indicator for the difficulty of a question */
enum Difficulty {
    EASY,
    MEDIUM,
    HARD;

    /**
     * Example: myDifficulty = myDifficulty.increaseDifficulty();
     * // Increase the difficulty of the enum, does not exceed HARD.
     * @return New Difficulty Enum
     */
    public Difficulty increaseDifficulty() {
        switch (this) {
            case EASY:
                return MEDIUM;
            case MEDIUM:
                return HARD;
            case HARD:
                return HARD;
            default:
                throw new IllegalStateException();
        }
    }
    /**
     * Example: myDifficulty = myDifficulty.decreaseDifficulty();
     * // Decrease the difficulty of the enum, does not go below EASY.
     * @return New Difficulty Enum
     */
    public Difficulty decreaseDifficulty() {
        switch (this) {
            case EASY:
                return EASY;
            case MEDIUM:
                return EASY;
            case HARD:
                return MEDIUM;
            default:
                throw new IllegalStateException();
        }
    }
}