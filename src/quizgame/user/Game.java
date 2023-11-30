package quizgame.user;

import quizgame.question.Question;
import quizgame.score.Score;
import quizgame.question.Filter;
import quizgame.question.QuestionGetter;

public class Game implements java.io.Serializable, Cloneable {
    public Question[] questions = new Question[6];
    public Score score = new Score();

    public void addQuestion(Question question) {
        Question[] newQuestions = new Question[questions.length + 1];
        for (int i = 0; i < questions.length; i++) {
            newQuestions[i] = questions[i];
        }
        newQuestions[questions.length + 1] = question;
        this.questions = newQuestions;
    }
    public void addQuestion(Filter filter, int amount) {
        // Prepare to expand Questions list
        // Copy into new tmp array
        Question[] newQuestions = new Question[questions.length + amount];
        for (int i = 0; i < questions.length; i++) {
            newQuestions[i] = questions[i];
        }

        // Get a new random question
        for (int i = 0; i < amount; i++) {
            Question newQuestion;
            if (filter == null) {
                newQuestion = QuestionGetter.getRandomQuestion();
            } else {
                newQuestion = QuestionGetter.getRandomQuestion(filter);
            }
            // Avoid duplicates, no need to check on first question
            if (i != 0 && newQuestion.question.equals(questions[i - 1].question)) {
                i--;
                continue;
            }
            newQuestions[questions.length + i] = newQuestion;
        }
        // Overwrite questions list
        this.questions = newQuestions.clone();
    }

    public Game clone() throws CloneNotSupportedException {
        return (Game) super.clone();
    }

    public static void main(String[] args) {
        Game g = new Game();
        g.addQuestion(null, 1);
        System.out.println(g.questions.length);
    }
}
