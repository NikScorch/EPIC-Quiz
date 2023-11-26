package quizgame.SceneController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;
import quizgame.*;
import quizgame.User;
import java.io.IOException;
import java.util.Objects;

public class Quiz {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Label questionField;
    @FXML
    private RadioButton optionA, optionB, optionC, optionD;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private Button tempButton, switchSceneButton;
    double progress;
    static User currentUser;
    int answer;

    /** This is the main quiz controller, it handles the display of questions, is in charge of calculating the score
     * and the progress button. **/

    // switches to the score scene once the user has answered all questions.
    public void switchToScore(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/quizgame/SceneController/resource/scoreScreen.fxml"));
        root = loader.load();
        QuizScore controller = loader.getController();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        controller.displayScore();
    }

    //uses back end question getter method to get all questions and display them on the screen.
    //switches between the next and score button
    //increases progress and counts score.
    public void questionDisplayDifficulty(quizgame.Difficulty diff) {
        int[] count = {0};
        switchSceneButton.setVisible(false);

        tempButton.setOnAction(e -> {
            if (count[0] < 6) {

                Question[] questions = QuestionGetter.getAllQuestionsByFilter(diff);
                if (count[0] < questions.length) {

                    questionField.setText(questions[count[0]].question);

                    optionA.setText(questions[count[0]].answers[0]);
                    optionB.setText(questions[count[0]].answers[1]);
                    optionC.setText(questions[count[0]].answers[2]);
                    optionD.setText(questions[count[0]].answers[3]);
                    count[0]++;
                    if (count[0] > 0) {
                        increaseProgress();
                    }
                    if (count[0] != 0) {
                        if (answer == questions[count[0]- 1].answerIndex) {
                            User.score++;
                        }
                    }
                }
            }
            if (count[0] == 6) {
                switchSceneButton.setVisible(true);
                tempButton.setVisible(false);
            }
        });
    }

    // follows the same logic as the previous method expect it displays questions of a certain topic.
    public void questionDisplayTopic(Topic topic) {
        int[] count = {0};
        switchSceneButton.setVisible(false);

        tempButton.setOnAction(e -> {
            if (count[0] < 6) {

                Question[] questions = QuestionGetter.getAllQuestionsByFilter(topic);
                if (count[0] < questions.length) {

                    questionField.setText(questions[count[0]].question);

                    optionA.setText(questions[count[0]].answers[0]);
                    optionB.setText(questions[count[0]].answers[1]);
                    optionC.setText(questions[count[0]].answers[2]);
                    optionD.setText(questions[count[0]].answers[3]);
                    count[0]++;
                    if (count[0] > 0) {
                        increaseProgress();
                    }
                    if (count[0] != 0) {
                        if (answer == questions[count[0]- 1].answerIndex) {
                            User.score++;
                        }
                    }
                }
                if (count[0] == 6) {
                    switchSceneButton.setVisible(true);
                    tempButton.setVisible(false);
                }
            }
        });
    }

    // also follows the same logic but displays any random question.
    public void questionDisplayRandom() {
        int[] count = {0};
        switchSceneButton.setVisible(false);

        tempButton.setOnAction(e -> {
            if (count[0] < 6) {

                Question[] questions = new Question[6];
                for (int i = 0; i < questions.length; i++) {
                    questions[i] = QuestionGetter.getRandomQuestion();
                }
                if (count[0] < questions.length) {

                    questionField.setText(questions[count[0]].question);

                    optionA.setText(questions[count[0]].answers[0]);
                    optionB.setText(questions[count[0]].answers[1]);
                    optionC.setText(questions[count[0]].answers[2]);
                    optionD.setText(questions[count[0]].answers[3]);
                    count[0]++;
                    if (count[0] > 0) {
                        increaseProgress();
                    }
                    if (count[0] != 0) {
                        if (answer == questions[count[0]- 1].answerIndex) {
                            User.score++;
                        }
                    }


                }
                    if (count[0] == 6) {
                        switchSceneButton.setVisible(true);
                        tempButton.setVisible(false);

                    }
            }
        });
    }

    //increase progress bar method, since there are 6 questions it increases by 0.167.
    public void increaseProgress() {
        progress += 0.167;
        progressBar.setProgress(progress);
    }

    // methods for when each option is selected, returns boolean.
    public boolean setOptionA() {
        return optionA.isSelected();
    }
    public boolean setOptionB() {
        return optionB.isSelected();
    }
    public boolean setOptionC() {
        return optionC.isSelected();
    }
    public boolean setOptionD() {
        return optionD.isSelected();
    }

    //checks for which option is selected when button is clicked on.
    public void scoreCounterReal(ActionEvent event) {
        if (setOptionA()) {
            answer = 0;
        }
        else if (setOptionB()) {
            answer = 1;
        }
        else if (setOptionC()) {
            answer = 2;
        }
        else if (setOptionD()) {
            answer =3;
        }

    }

    // testing purposes only.
    public static void main(String[] args) {
        System.out.println(User.score);
    }
}
