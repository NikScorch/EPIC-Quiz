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

import static quizgame.QuestionGetter.questions;

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
    static int score = 0;
    int selectedOption = -1;

    public void switchToScore(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(Gui.class.getResource("/quizgame/SceneController/resource/scoreScreen.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void test(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/quizgame/SceneController/resource/scoreScreen.fxml"));
        root = loader.load();
        QuizScore controller = loader.getController();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        controller.displayScore();
    }

    public void scoreCounter(ActionEvent event) {

        if (optionA.isSelected()) {
            int answer = 0;
        }
        else if (optionB.isSelected()) {
            int answer = 1;
        }
        else if (optionC.isSelected()) {
            int answer = 2;
        }
        else {
            int answer = 3;
        }
    }

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
                }
            }
            if (count[0] == 6) {
                switchSceneButton.setVisible(true);
                tempButton.setVisible(false);
            }
        });
    }

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
                }
                if (count[0] == 6) {
                    switchSceneButton.setVisible(true);
                    tempButton.setVisible(false);
                }
            }
        });
    }

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

                    if (selectedOption != -1) {
                        questions[count[0]].userAnswer = selectedOption;
                        int correctAnswer = questions[count[0]].answerIndex;
                        if (selectedOption == correctAnswer) {
                            score ++;
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

    //TODO: make this fucking work its been weeks i cannot rn, go kys.
    public void questionDisplay() {
        int[] count = { 0 };
        switchSceneButton.setVisible(false);

        tempButton.setOnAction(e -> {
            if (! (count[0] == 0)) {
                questions[count[0] - 1] = QuestionGetter.getRandomQuestion();
                QuestionGetter.loadQuestions();

                // get selected value and update
                // do not do this on the first option


                if (optionA.isSelected()) { selectedOption = currentUser.data.questions[count[0] - 1].userAnswer = 0;}
                else if (optionB.isSelected()) { selectedOption = currentUser.data.questions[count[0] - 1].userAnswer = 1; }
                else if (optionC.isSelected()) { selectedOption = currentUser.data.questions[count[0] - 1].userAnswer = 2; }
                else { selectedOption = currentUser.data.questions[count[0] - 1].userAnswer = 3; }

                if (selectedOption != -1) {
                    currentUser.data.questions[count[0] - 1].userAnswer = selectedOption;
                    int correctAnswer = currentUser.data.questions[count[0] - 1].answerIndex;

                    if (selectedOption == correctAnswer) {
                        score ++;
                    }
                }

            }
            if (count[0] < 6) {

                if (count[0] < currentUser.data.questions.length) {

                    questionField.setText(currentUser.data.questions[count[0]].question);

                    optionA.setText(currentUser.data.questions[count[0]].answers[0]);
                    optionB.setText(currentUser.data.questions[count[0]].answers[1]);
                    optionC.setText(currentUser.data.questions[count[0]].answers[2]);
                    optionD.setText(currentUser.data.questions[count[0]].answers[3]);
                    count[0]++;
                    if (count[0] > 0) {
                        increaseProgress();
                        //this.currentUser.quizgame.storeQuestion(questions[count[0]]);
                    }
                }

            }

            if (count[0] == 6) {
                switchSceneButton.setVisible(true);
                tempButton.setVisible(false);
            }

        });
    }
    public void increaseProgress() {
        progress += 0.167;
        progressBar.setProgress(progress);
    }
}
