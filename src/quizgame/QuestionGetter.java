package quizgame;

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
        new Question(null, null, 0, Topic.DISCRETE_MATHS, Difficulty.EASY),   
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

    // public static void complete_random_game() {}
    public static Question getRandomQuestion() {
        return questions[(int) (Math.random() * questions.length)];
    }

    // public static void specific_subject_random_game(Topic topic) {}
    public static Question getRandomQuestionBySubject(Topic topic) {
        int questionsForTopic = 0;
        for (Question q: questions) {
            if (q.topic == topic) {
                questionsForTopic++;
            }
        }

        int randomQuestionIndex = (int) Math.random() * (questionsForTopic + 1);
        int i = 0;
        for (Question q: questions) {
            if (q.topic != topic) {
                continue;
            }
            
        }

        return questions[0];
    }

    public static Question getRandomQuestionBySubjectAndDifficulty(Topic topic, Difficulty difficulty) { return questions[0]; }
    
    public static void increasing_difficulty_game() {}

    public static void main(String[] args) {
        //specific_subject_random_game(Topic.COMPUTER_SCIENCE);
        getRandomQuestion();



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
    HARD
}