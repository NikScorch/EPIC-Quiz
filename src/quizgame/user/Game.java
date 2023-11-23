package quizgame.user;

import quizgame.question.Question;
import quizgame.score.Score;

public class Game implements java.io.Serializable, Cloneable {
    public Question[] questions = new Question[6];
    public Score score = new Score();

    public Game clone() throws CloneNotSupportedException {
        return (Game) super.clone();
    }
}
