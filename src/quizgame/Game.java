package quizgame;

public class Game implements java.io.Serializable, Cloneable {
    Question[] questions = new Question[6];
    Score score = new Score();

    protected Game clone() throws CloneNotSupportedException {
        return (Game) super.clone();
    }
}
