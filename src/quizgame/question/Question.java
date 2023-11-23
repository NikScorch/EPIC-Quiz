package quizgame.question;

/**
 * Stores all relavant data regarding a question in a single object
 */
public class Question implements java.io.Serializable {
    public String question;
    public String[] answers;
    public int answerIndex;
    public int userAnswer;
    public Topic topic;
    public Difficulty difficulty;

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