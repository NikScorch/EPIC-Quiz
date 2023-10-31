package quizgame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
    private Button tempButton, switchSceneButton;
    @FXML
    private Label questionField, firstPlace, secondPlace, thirdPlace;
    @FXML
    private RadioButton optionA, optionB, optionC, optionD;
    @FXML
    TextField usernameTextField, registerUserTextField;
    @FXML
    PasswordField passwordTextField, registerPasswordField, reEnterPasswordField;
    double progress;
    User currentUser;

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


    public void switchToScore(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(Gui.class.getResource("resource/scoreScreen.fxml")));
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


    public void switchToPlayagain(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("resource/playagainScreen.fxml"));
        root = loader.load();

        SwitchSceneController controller = loader.getController();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        controller.leaderBoardSettings();
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
        controller.questionDisplayDifficulty(Difficulty.EASY);

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
        controller.questionDisplayDifficulty(Difficulty.MEDIUM);
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
        controller.questionDisplayDifficulty(Difficulty.HARD);
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
        controller.questionDisplayRandom();
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
        controller.questionDisplayTopic(Topic.DISCRETE_MATHS);
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
        controller.questionDisplayTopic(Topic.COMP_ORG);
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
        controller.questionDisplayTopic(Topic.COMPUTER_SCIENCE);
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



    public void questionDisplayDifficulty(Difficulty diff) {
        int[] count = {0};
        switchSceneButton.setVisible(false);

        tempButton.setOnAction(e -> {
            if (count[0] < 7) {

                Question[] questions = QuestionGetter.getAllQuestionsByFilter(diff);
                if (count[0] < questions.length) {

                    questionField.setText(questions[count[0]].question);

                    optionA.setText(questions[count[0]].answers[0]);
                    optionB.setText(questions[count[0]].answers[1]);
                    optionC.setText(questions[count[0]].answers[2]);
                    optionD.setText(questions[count[0]].answers[3]);
                    count[0]++;
                    if (count[0] > 1) {
                        increaseProgress();
                        //this.currentUser.storeQuestion(questions[count[0]]);
                    }
                }

            }

            if (count[0] == 7) {
                switchSceneButton.setVisible(true);
                tempButton.setVisible(false);
            }

        });
    }



    public void questionDisplayRandom() {
        int[] count = {0};
        switchSceneButton.setVisible(false);

        tempButton.setOnAction(e -> {
            if (count[0] < 7) {


                //broken
                Question[] questions = new Question[]{QuestionGetter.getRandomQuestion()};
                if (count[0] < questions.length) {

                    questionField.setText(questions[count[0]].question);

                    optionA.setText(questions[count[0]].answers[0]);
                    optionB.setText(questions[count[0]].answers[1]);
                    optionC.setText(questions[count[0]].answers[2]);
                    optionD.setText(questions[count[0]].answers[3]);
                    count[0]++;
                    if (count[0] > 1) {
                        increaseProgress();
                        //this.currentUser.storeQuestion(questions[count[0]]);
                    }
                }

                if (count[0] == 7) {
                    switchSceneButton.setVisible(true);
                    tempButton.setVisible(false);
                }
            }

        });
    }

    public void questionDisplayTopic(Topic topic) {
        int[] count = {0};
        switchSceneButton.setVisible(false);

        tempButton.setOnAction(e -> {
            if (count[0] < 7) {

                Question[] questions = QuestionGetter.getAllQuestionsByFilter(topic);
                if (count[0] < questions.length) {

                    questionField.setText(questions[count[0]].question);

                    optionA.setText(questions[count[0]].answers[0]);
                    optionB.setText(questions[count[0]].answers[1]);
                    optionC.setText(questions[count[0]].answers[2]);
                    optionD.setText(questions[count[0]].answers[3]);
                    count[0]++;
                    if (count[0] > 1) {
                        increaseProgress();
                        //this.currentUser.storeQuestion(questions[count[0]]);
                    }
                }

                if (count[0] == 7) {
                    switchSceneButton.setVisible(true);
                    tempButton.setVisible(false);
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

    }




    public void login(ActionEvent event) throws IOException {
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error!");
        alert.setHeaderText("User does not exist.");
        alert.setContentText("Invalid username, please register or recheck your username.");


        if (LoginManager.userExists(username)) {
            this.currentUser = LoginManager.loadUser(username);
            if(currentUser.verifyPassword(password)) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("resource/settingsScreen.fxml"));
                root = loader.load();
                SwitchSceneController controller = loader.getController();
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
            else {
                alert.showAndWait();
            }
        }
        else {
            alert.showAndWait();
        }
    }



    public void register(ActionEvent event) throws IOException {
    String username = registerUserTextField.getText();
    String password = registerPasswordField.getText();
    String reEnterPassword = reEnterPasswordField.getText();
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error!");
        alert.setHeaderText("Passwords do not match");
        alert.setContentText("Re-enter your password and check for spelling errors");

    if(password.equals(reEnterPassword)) {
        LoginManager.registerUser(username, password);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("resource/hello-view.fxml"));
        root = loader.load();
        SwitchSceneController controller = loader.getController();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    else{
        alert.showAndWait();
    }
    }





    public void leaderBoardSettings(){
        firstPlace.setText("hii");
        secondPlace.setText("no");
        thirdPlace.setText("this was a test");
    }


}
