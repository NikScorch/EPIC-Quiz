package quizgame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class SwitchSceneController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button exitButton;
    @FXML
    private AnchorPane exitPane;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private Button tempButton;
    @FXML
    private Label questionField;
    @FXML
    private RadioButton optionA, optionB, optionC, optionD;
    double progress;
    Question[] answeredQuestions = new Question[6];
    int easyScore = 0;

    public void switchToRegister(ActionEvent event) throws IOException {
       root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("resource/registerScreen.fxml")));
       stage = (Stage)((Node)event.getSource()).getScene().getWindow();
       scene = new Scene(root);
       stage.setScene(scene);
       stage.show();
    }
    public void switchToDifficulty(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(Gui.class.getResource("resource/difficultyScreen.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToSubject(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(Gui.class.getResource("resource/subjectScreen.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToInstructions(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(Gui.class.getResource("resource/instructionsScreen.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToScore(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(Gui.class.getResource("resource/scoreScreen.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToPlayagain(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(Gui.class.getResource("resource/playagainScreen.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToHello(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(Gui.class.getResource("resource/hello-view.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSettings(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(Gui.class.getResource("resource/settingsScreen.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToQuiz(ActionEvent event) throws IOException {
        //root = FXMLLoader.load(Objects.requireNonNull(Gui.class.getResource("resource/quizScreen.fxml")));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("resource/quizScreen.fxml"));
        root = loader.load();

        SwitchSceneController controller = loader.getController();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        controller.easyQuestionDisplay();

    }

    public void switchToQuizEasy(ActionEvent event) throws IOException {
        //root = FXMLLoader.load(Objects.requireNonNull(Gui.class.getResource("resource/quizScreen.fxml")));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("resource/quizScreen.fxml"));
        root = loader.load();

        SwitchSceneController controller = loader.getController();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        controller.easyQuestionDisplay();

    }
    public void switchToQuizMedium(ActionEvent event) throws IOException {
        //root = FXMLLoader.load(Objects.requireNonNull(Gui.class.getResource("resource/quizScreen.fxml")));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("resource/quizScreen.fxml"));
        root = loader.load();

        SwitchSceneController controller = loader.getController();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        controller.mediumQuestionDisplay();
    }
    public void switchToQuizHard(ActionEvent event) throws IOException {
        //root = FXMLLoader.load(Objects.requireNonNull(Gui.class.getResource("resource/quizScreen.fxml")));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("resource/quizScreen.fxml"));
        root = loader.load();
        SwitchSceneController controller = loader.getController();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        controller.hardQuestionDisplay();
    }
    public void switchToQuizRandom(ActionEvent event) throws IOException {
        //root = FXMLLoader.load(Objects.requireNonNull(Gui.class.getResource("resource/quizScreen.fxml")));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("resource/quizScreen.fxml"));
        root = loader.load();
        SwitchSceneController controller = loader.getController();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        controller.randomQuestionDisplay();
    }
    public void switchToQuizMaths(ActionEvent event) throws IOException {
        //root = FXMLLoader.load(Objects.requireNonNull(Gui.class.getResource("resource/quizScreen.fxml")));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("resource/quizScreen.fxml"));
        root = loader.load();
        SwitchSceneController controller = loader.getController();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        controller.mathsQuestionDisplay();
    }
    public void switchToQuizCompOrg(ActionEvent event) throws IOException {
        //root = FXMLLoader.load(Objects.requireNonNull(Gui.class.getResource("resource/quizScreen.fxml")));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("resource/quizScreen.fxml"));
        root = loader.load();
        SwitchSceneController controller = loader.getController();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        controller.compOrgQuestionDisplay();
    }
    public void switchToQuizCompSci(ActionEvent event) throws IOException {
        //root = FXMLLoader.load(Objects.requireNonNull(Gui.class.getResource("resource/quizScreen.fxml")));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("resource/quizScreen.fxml"));
        root = loader.load();
        SwitchSceneController controller = loader.getController();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        controller.compSciQuestionDisplay();
    }




    public void exit(ActionEvent event) {
        stage = (Stage) exitPane.getScene().getWindow();
        stage.close();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}
    public void increaseProgress() {
        progress += 0.167;
        progressBar.setProgress(progress);
    }


    public void easyQuestionDisplay() {
        int[] count = {0};

        tempButton.setOnAction(e -> {
            if (count[0] < 6) {

                Question[] questions = QuestionGetter.getAllQuestionsByFilter(Difficulty.EASY);
                if (count[0] < questions.length) {

                    questionField.setText(questions[count[0]].question);

                    optionA.setText(questions[count[0]].answers[0]);
                    optionB.setText(questions[count[0]].answers[1]);
                    optionC.setText(questions[count[0]].answers[2]);
                    optionD.setText(questions[count[0]].answers[3]);
                    count[0]++;
                }
                increaseProgress();

            }
        });
    }


    public void mediumQuestionDisplay() {
        int[] count = {0};

        tempButton.setOnAction(e -> {
            if (count[0] < 6) {

                Question[] questions = QuestionGetter.getAllQuestionsByFilter(Difficulty.MEDIUM);
                if (count[0] < questions.length) {

                    questionField.setText(questions[count[0]].question);

                    optionA.setText(questions[count[0]].answers[0]);
                    optionB.setText(questions[count[0]].answers[1]);
                    optionC.setText(questions[count[0]].answers[2]);
                    optionD.setText(questions[count[0]].answers[3]);
                    count[0]++;
                }
            }
        });
    }
    public void hardQuestionDisplay() {
        int[] count = {0};

        tempButton.setOnAction(e -> {
            if (count[0] < 6) {

                Question[] questions = QuestionGetter.getAllQuestionsByFilter(Difficulty.MEDIUM);
                if (count[0] < questions.length) {

                    questionField.setText(questions[count[0]].question);

                    optionA.setText(questions[count[0]].answers[0]);
                    optionB.setText(questions[count[0]].answers[1]);
                    optionC.setText(questions[count[0]].answers[2]);
                    optionD.setText(questions[count[0]].answers[3]);
                    count[0]++;
                }
            }
        });
    }
    public void mathsQuestionDisplay() {
        int[] count = {0};

        tempButton.setOnAction(e -> {
            if (count[0] < 6) {

                Question[] questions = QuestionGetter.getAllQuestionsByFilter(Topic.DISCRETE_MATHS);
                if (count[0] < questions.length) {

                    questionField.setText(questions[count[0]].question);

                    optionA.setText(questions[count[0]].answers[0]);
                    optionB.setText(questions[count[0]].answers[1]);
                    optionC.setText(questions[count[0]].answers[2]);
                    optionD.setText(questions[count[0]].answers[3]);
                    count[0]++;
                }
            }
        });
    }
    public void compOrgQuestionDisplay() {
        int[] count = {0};

        tempButton.setOnAction(e -> {
            if (count[0] < 6) {

                Question[] questions = QuestionGetter.getAllQuestionsByFilter(Topic.COMP_ORG);
                if (count[0] < questions.length) {

                    questionField.setText(questions[count[0]].question);

                    optionA.setText(questions[count[0]].answers[0]);
                    optionB.setText(questions[count[0]].answers[1]);
                    optionC.setText(questions[count[0]].answers[2]);
                    optionD.setText(questions[count[0]].answers[3]);
                    count[0]++;
                }
            }
        });
    }
    public void compSciQuestionDisplay() {
        int[] count = {0};

        tempButton.setOnAction(e -> {
            if (count[0] < 6) {

                Question[] questions = QuestionGetter.getAllQuestionsByFilter(Topic.COMPUTER_SCIENCE);
                if (count[0] < questions.length) {

                    questionField.setText(questions[count[0]].question);

                    optionA.setText(questions[count[0]].answers[0]);
                    optionB.setText(questions[count[0]].answers[1]);
                    optionC.setText(questions[count[0]].answers[2]);
                    optionD.setText(questions[count[0]].answers[3]);
                    count[0]++;
                }
            }
        });
    }

    public void randomQuestionDisplay() {
        final int[] count = {0};

        tempButton.setOnAction(e -> {
            if (count[0] < 6) {
                Question[] questions = new Question[]{QuestionGetter.getRandomQuestion()};
                if (count[0] < questions.length) {
                    questionField.setText(questions[count[0]].question);
                    optionA.setText(questions[count[0]].answers[0]);
                    optionB.setText(questions[count[0]].answers[1]);
                    optionC.setText(questions[count[0]].answers[2]);
                    optionD.setText(questions[count[0]].answers[3]);
                    count[0]++;
                }
            }
        });
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
        for (Question q : answeredQuestions) {

            if (q.difficulty != Difficulty.EASY) {
                continue;
            }
            easyScore++;
        }
        increaseProgress();


    }
}