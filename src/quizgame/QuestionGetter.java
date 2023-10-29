package quizgame;

import java.util.ArrayList;
import java.util.List;

public class QuestionGetter {
    /*
     * Make an array of Question classes
     * This is our Question bank, it looks horrendous but it will have to do
     * When defining a new entry, the format is as follows:
     * new Question("How many legs does a dog have?", 
     *               new String[]{"2","4","7","5"}, 1, 
     *               Topic.COMP_ORG, Difficulty.EASY),
     */
    static Question[] questions = {
        //      Discrete Maths Questions
        // Easy Questions
        new Question("How many legs does a dog have?", new String[]{"2","4","7","5"}, 1, Topic.DISCRETE_MATHS, Difficulty.EASY),
        new Question(null, null, 0, Topic.DISCRETE_MATHS, Difficulty.EASY),   
        // Medium Questions
        new Question(null, null, 0, Topic.DISCRETE_MATHS, Difficulty.MEDIUM), 
        new Question(null, null, 0, Topic.DISCRETE_MATHS, Difficulty.MEDIUM), 
        // Hard Questions
        new Question(null, null, 0, Topic.DISCRETE_MATHS, Difficulty.HARD),   
        new Question(null, null, 0, Topic.DISCRETE_MATHS, Difficulty.HARD),   

        //      Computer Organisation Questions
        // Easy Questions
        new Question(null, null, 0, Topic.COMP_ORG, Difficulty.EASY),
        new Question(null, null, 0, Topic.COMP_ORG, Difficulty.EASY),
        // Medium Questions
        new Question(null, null, 0, Topic.COMP_ORG, Difficulty.MEDIUM),
        new Question(null, null, 0, Topic.COMP_ORG, Difficulty.MEDIUM),
        // Hard Questions
        new Question(null, null, 0, Topic.COMP_ORG, Difficulty.HARD),
        new Question(null, null, 0, Topic.COMP_ORG, Difficulty.HARD),

        //      Computer Science Questions
        // Easy Questions
        new Question(null, null, 0, Topic.COMPUTER_SCIENCE, Difficulty.EASY),
        new Question(null, null, 0, Topic.COMPUTER_SCIENCE, Difficulty.EASY),
        // Medium Questions
        new Question(null, null, 0, Topic.COMPUTER_SCIENCE, Difficulty.MEDIUM),
        new Question(null, null, 0, Topic.COMPUTER_SCIENCE, Difficulty.MEDIUM),
        // Hard Questions
        new Question(null, null, 0, Topic.COMPUTER_SCIENCE, Difficulty.HARD),
        new Question(null, null, 0, Topic.COMPUTER_SCIENCE, Difficulty.HARD),
    };

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
        getRandomQuestion();

        Question q = new Question("How many legs does a dog have?", new String[]{"2","4","7","5"}, 1, Topic.COMP_ORG, Difficulty.EASY);
        q.print();

        Question[] qs = getAllQuestionsByFilter(Topic.COMPUTER_SCIENCE);
        System.out.println(java.util.Arrays.toString(qs));
        System.out.println(qs.length);


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