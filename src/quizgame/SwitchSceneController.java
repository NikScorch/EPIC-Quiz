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
    private AnchorPane exitPane;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private Button tempButton, switchSceneButton, exitButton;
    @FXML
    private Label questionField, firstPlace, secondPlace, thirdPlace;
    @FXML
    private RadioButton optionA, optionB, optionC, optionD;
    @FXML
    TextField usernameTextField, registerUserTextField;
    @FXML
    PasswordField passwordTextField, registerPasswordField, reEnterPasswordField;
    double progress;
    static User currentUser;
    public void switchToRegister(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("resource/registerScreen.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    // switches to the difficulty screen

    public void switchToDifficulty(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(Gui.class.getResource("resource/difficultyScreen.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //switches to the subject screen
    public void switchToSubject(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(Gui.class.getResource("resource/subjectScreen.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //switches to the score screen
    public void switchToScore(ActionEvent event) throws IOException {
        // TODO: if you ever wanted to fix proper spagetti code well now is your chance buckaroo
        // have at yee
        if (optionA.isSelected()) { currentUser.data.questions[5].userAnswer = 0; }
        else if (optionA.isSelected()) { currentUser.data.questions[5].userAnswer = 1; }
        else if (optionA.isSelected()) { currentUser.data.questions[5].userAnswer = 2; }
        else { currentUser.data.questions[5].userAnswer = 3; }

        root = FXMLLoader.load(Objects.requireNonNull(Gui.class.getResource("resource/scoreScreen.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //switches to the main beginning screen
    public void switchToHello(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(Gui.class.getResource("resource/hello-view.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //switches to the setting screen
    public void switchToSettings(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(Gui.class.getResource("resource/settingsScreen.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //switches to the play again screen
    public void switchToPlayagain(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("resource/playagainScreen.fxml"));
        root = loader.load();

        SwitchSceneController controller = loader.getController();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        controller.leaderBoardSettings();
    }

    //when easy difficulty is selected, it switches to the quiz screen and calls the question display method
    public void switchToQuizEasy(ActionEvent event) throws IOException {
        // root =
        // FXMLLoader.load(Objects.requireNonNull(Gui.class.getResource("resource/quizScreen.fxml")));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("resource/quizScreen.fxml"));
        root = loader.load();

        SwitchSceneController controller = loader.getController();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        currentUser.data.questions = QuestionGetter.getAllQuestionsByFilter(Difficulty.EASY);
        controller.questionDisplay();

    }

    //when medium difficulty is selected, it switches to the quiz screen and calls the question display method
    public void switchToQuizMedium(ActionEvent event) throws IOException {
        // root =
        // FXMLLoader.load(Objects.requireNonNull(Gui.class.getResource("resource/quizScreen.fxml")));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("resource/quizScreen.fxml"));
        root = loader.load();

        SwitchSceneController controller = loader.getController();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        currentUser.data.questions = QuestionGetter.getAllQuestionsByFilter(Difficulty.MEDIUM);
        controller.questionDisplay();
    }

    //when hard difficulty is selected, it switches to the quiz screen and calls the question display method
    public void switchToQuizHard(ActionEvent event) throws IOException {
        // root =
        // FXMLLoader.load(Objects.requireNonNull(Gui.class.getResource("resource/quizScreen.fxml")));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("resource/quizScreen.fxml"));
        root = loader.load();
        SwitchSceneController controller = loader.getController();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        currentUser.data.questions = QuestionGetter.getAllQuestionsByFilter(Difficulty.HARD);
        controller.questionDisplay();
    }


    //when random is selected, it switches to the quiz screen and calls the random question display method
    public void switchToQuizRandom(ActionEvent event) throws IOException {
        //root = FXMLLoader.load(Objects.requireNonNull(Gui.class.getResource("resource/quizScreen.fxml")));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("resource/quizScreen.fxml"));
        root = loader.load();
        SwitchSceneController controller = loader.getController();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        currentUser.data.questions = QuestionGetter.getAllQuestionsByFilter(Topic.DISCRETE_MATHS);
        controller.questionDisplay();
        //controller.questionDisplayTopic(Topic.DISCRETE_MATHS);
    }

    //when discrete maths is selected, it switches to the quiz screen and calls the question display method
    public void switchToQuizMaths(ActionEvent event) throws IOException {
        //root = FXMLLoader.load(Objects.requireNonNull(Gui.class.getResource("resource/quizScreen.fxml")));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("resource/quizScreen.fxml"));
        root = loader.load();
        SwitchSceneController controller = loader.getController();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        currentUser.data.questions = QuestionGetter.getAllQuestionsByFilter(Topic.COMP_ORG);
        controller.questionDisplay();
        // controller.questionDisplayTopic(Topic.COMP_ORG);
    }

    //when computer organization is selected, it switches to the quiz screen and calls the question display method
    public void switchToQuizCompOrg(ActionEvent event) throws IOException {
        //root = FXMLLoader.load(Objects.requireNonNull(Gui.class.getResource("resource/quizScreen.fxml")));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("resource/quizScreen.fxml"));
        root = loader.load();
        SwitchSceneController controller = loader.getController();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        currentUser.data.questions = QuestionGetter.getAllQuestionsByFilter(Topic.COMPUTER_SCIENCE);
        controller.questionDisplay();
        // controller.questionDisplayTopic(Topic.COMPUTER_SCIENCE);
    }

    //when computer science is selected, it switches to the quiz screen and calls the question display method
    public void switchToQuizCompSci(ActionEvent event) throws IOException {
        //root = FXMLLoader.load(Objects.requireNonNull(Gui.class.getResource("resource/quizScreen.fxml")));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("resource/quizScreen.fxml"));
        root = loader.load();
        SwitchSceneController controller = loader.getController();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        for (int i = 0; i < currentUser.data.questions.length; i++) {
            currentUser.data.questions[i] = QuestionGetter.getRandomQuestion();
        }
        controller.questionDisplay();
        // controller.questionDisplayRandom();
    }

    public void playAgain(ActionEvent event) throws IOException {
        LoginManager.saveUser(currentUser);
        // currentUser.saveSession();
        switchToSettings(event);
    }

    // this is used on the exit button to end the program and exit at the end
    public void exit(ActionEvent event) {
        System.out.println("Program ended");
        LoginManager.saveUser(currentUser);
        stage = (Stage) exitPane.getScene().getWindow();
        stage.close();
    }

    //this is to increase the progressbar
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void increaseProgress() {
        progress += 0.167;
        progressBar.setProgress(progress);
    }

    public void questionDisplay() {
        int[] count = { 0 };
        switchSceneButton.setVisible(false);

        tempButton.setOnAction(e -> {
            if (! (count[0] == 0)) {
                // get selected value and update 
                // do not do this on the first option
                if (optionA.isSelected()) { currentUser.data.questions[count[0] - 1].userAnswer = 0; }
                else if (optionA.isSelected()) { currentUser.data.questions[count[0] - 1].userAnswer = 1; }
                else if (optionA.isSelected()) { currentUser.data.questions[count[0] - 1].userAnswer = 2; }
                else { currentUser.data.questions[count[0] - 1].userAnswer = 3; }
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
                        // this.currentUser.storeQuestion(questions[count[0]]);
                    }
                }

            }

            if (count[0] == 6) {
                switchSceneButton.setVisible(true);
                tempButton.setVisible(false);
            }

        });
    }

    public void questionDisplayDifficulty(Difficulty diff) {
        int[] count = { 0 };
        switchSceneButton.setVisible(false);

        tempButton.setOnAction(e -> {
            System.out.println("pressed");
            if (count[0] < 6) {

                Question[] questions = QuestionGetter.getAllQuestionsByFilter(diff);
                if (count[0] < this.currentUser.data.questions.length) {

                    questionField.setText(this.currentUser.data.questions[count[0]].question);

                    optionA.setText(this.currentUser.data.questions[count[0]].answers[0]);
                    optionB.setText(this.currentUser.data.questions[count[0]].answers[1]);
                    optionC.setText(this.currentUser.data.questions[count[0]].answers[2]);
                    optionD.setText(this.currentUser.data.questions[count[0]].answers[3]);
                    count[0]++;
                    if (count[0] > 0) {
                        increaseProgress();
                        // this.currentUser.storeQuestion(questions[count[0]]);
                    }
                }

            }

            if (count[0] == 6) {
                switchSceneButton.setVisible(true);
                tempButton.setVisible(false);
            }

        });
    }

    public void questionDisplayRandom() {
        int[] count = { 0 };
        switchSceneButton.setVisible(false);

        tempButton.setOnAction(e -> {
            if (count[0] < 6) {

                // broken
                Question[] questions = new Question[6];
                for (int i = 0; i < questions.length; i++) {
                    questions[i] = QuestionGetter.getRandomQuestion();
                }
                if (count[0] < this.currentUser.data.questions.length) {

                    questionField.setText(this.currentUser.data.questions[count[0]].question);

                    optionA.setText(this.currentUser.data.questions[count[0]].answers[0]);
                    optionB.setText(this.currentUser.data.questions[count[0]].answers[1]);
                    optionC.setText(this.currentUser.data.questions[count[0]].answers[2]);
                    optionD.setText(this.currentUser.data.questions[count[0]].answers[3]);
                    count[0]++;
                    // if (count[0] > 0) {
                    // // this.currentUser.storeQuestion(questions[count[0]]);
                    increaseProgress();
                    // }
                }

                if (count[0] == 6) {
                    switchSceneButton.setVisible(true);
                    tempButton.setVisible(false);
                }
            }

        });
    }

    public void questionDisplayTopic(Topic topic) {
        int[] count = { 0 };
        switchSceneButton.setVisible(false);

        tempButton.setOnAction(e -> {
            if (count[0] < 6) {

                Question[] questions = QuestionGetter.getAllQuestionsByFilter(topic);
                if (count[0] < this.currentUser.data.questions.length) {

                    questionField.setText(this.currentUser.data.questions[count[0]].question);

                    optionA.setText(this.currentUser.data.questions[count[0]].answers[0]);
                    optionB.setText(this.currentUser.data.questions[count[0]].answers[1]);
                    optionC.setText(this.currentUser.data.questions[count[0]].answers[2]);
                    optionD.setText(this.currentUser.data.questions[count[0]].answers[3]);
                    count[0]++;
                    if (count[0] > 0) {
                        increaseProgress();
                        // this.currentUser.storeQuestion(questions[count[0]]);
                    }
                }

                if (count[0] == 6) {
                    switchSceneButton.setVisible(true);
                    tempButton.setVisible(false);
                }
            }

        });
    }

    //was an idea to calculate the scores but :(
    public int scoreCounter(ActionEvent event) {
        if (optionA.isSelected()) {
            return 0;
        } else if (optionB.isSelected()) {
            return 1;
        } else if (optionC.isSelected()) {
            return 2;
        } else {
            return 3;
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
            currentUser = LoginManager.loadUser(username);
            if (currentUser.verifyPassword(password)) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("resource/settingsScreen.fxml"));
                root = loader.load();
                SwitchSceneController controller = loader.getController();
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } else {
                alert.showAndWait();
            }
        } else {
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

        if (password.equals(reEnterPassword)) {
            this.currentUser = LoginManager.registerUser(username, password);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("resource/settingsScreen.fxml"));
            root = loader.load();
            SwitchSceneController controller = loader.getController();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            alert.showAndWait();
        }
    }

    //leaderboard to display users
    public void leaderBoardSettings(){
        Leaderboard.reloadUsers();
        User[] topThree = Leaderboard.getTopThree();
        firstPlace.setText(topThree[0].username);
        secondPlace.setText(topThree[1].username);
        thirdPlace.setText(topThree[2].username);
    }

}
