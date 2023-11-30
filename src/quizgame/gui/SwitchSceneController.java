package quizgame.gui;

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
import quizgame.question.Difficulty;
import quizgame.question.Filter;
import quizgame.question.Question;
import quizgame.question.QuestionGetter;
import quizgame.question.Topic;
import quizgame.score.Leaderboard;
import quizgame.user.LoginManager;
import quizgame.user.User;

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

    // Infer what button what selected and change the scene accordingly
    public void pageSelector(ActionEvent event) throws IOException {
        pageSelector(event, null);
    }
    public void pageSelector(ActionEvent event, String id) throws IOException {
        if (id == null) {
            id = ( (Button) event.getSource() ).getId();
        }
        switch (id) {
            case "hellopage":
                loadScene(event, "/quizgame/resource/hello-view.fxml");
                break;
            case "registerButton":
                loadScene(event, "/quizgame/resource/registerScreen.fxml");
                break;
            case "settings":
                loadScene(event, "/quizgame/resource/settingsScreen.fxml");
                break;
            case "difficulty":
                loadScene(event, "/quizgame/resource/difficultyScreen.fxml");
                break;
            case "subject":
                loadScene(event, "/quizgame/resource/subjectScreen.fxml");
                break;
            case "playagain":
                SwitchSceneController controller = loadScene(event, "/quizgame/resource/playagainScreen.fxml");
                controller.leaderBoardSettings();
                break;
            case "easy":
                loadQuizScene(event, Difficulty.EASY);
                break;
            case "medium":
                loadQuizScene(event, Difficulty.MEDIUM);
                break;
            case "hard":
                loadQuizScene(event, Difficulty.HARD);
                break;
            case "discrete_maths":
                loadQuizScene(event, Topic.DISCRETE_MATHS);
                break;
            case "comp_org":
                loadQuizScene(event, Topic.COMP_ORG);
                break;
            case "comp_sci":
                loadQuizScene(event, Topic.COMPUTER_SCIENCE);
                break;
            case "random":
                loadQuizScene(event);
                break;
            case "rising":
                SwitchSceneController tmpcontroller = loadScene(event, "/quizgame/resource/quizScreen.fxml");

                int k = 0;
                for (Filter filter: new Filter[]{Difficulty.EASY, Difficulty.MEDIUM, Difficulty.HARD}) {
                    for (int j = 0; j < 2; j++) {
                        currentUser.data.questions[k] = QuestionGetter.getRandomQuestion(filter);
                        k++;
                    }
                }
                tmpcontroller.questionDisplay();
                break;
            default:
                System.out.println("Id not found" + id);
                break;
        }
    }

    SwitchSceneController loadScene(ActionEvent event, String resourceFile) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(resourceFile));
        root = loader.load();
        SwitchSceneController controller = loader.getController();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        return controller;
    }

    public void loadQuizScene(ActionEvent event) throws IOException {
        loadQuizScene(event, null);
    }
    public void loadQuizScene(ActionEvent event, Filter filter) throws IOException {
        SwitchSceneController controller = loadScene(event, "/quizgame/resource/quizScreen.fxml");
        // Get questions
        for (int i = 0; i < currentUser.data.questions.length; i++) {
            Question new_Question;
            if (filter == null) {
                new_Question = QuestionGetter.getRandomQuestion();
            } else {
                new_Question = QuestionGetter.getRandomQuestion(filter);
            }
            // Avoid duplicates, no need to check on first question
            if (i != 0 && new_Question.question.equals(currentUser.data.questions[i - 1].question)) {
                i--;
                System.out.println("dupe found");
                continue;
            }
            currentUser.data.questions[i] = new_Question;
        }
        controller.questionDisplay();
    }

    public void playAgain(ActionEvent event) throws IOException {
        LoginManager.saveUser(currentUser);
        pageSelector(event, "settings");
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
        System.out.println(url.toString());
    }

    public void increaseProgress() {
        progress += 0.167;
        progressBar.setProgress(progress);
    }

    public void selectAnswer(ActionEvent event, Question q) {
        if (optionA.isSelected()) {
            q.userAnswer = 0;
        } 
        else if (optionB.isSelected()) {
            q.userAnswer = 1;
        } 
        else if (optionC.isSelected()) {
            q.userAnswer = 2;
        } 
        else if (optionD.isSelected()) {
            q.userAnswer = 3;
        }
    }
    
    public void showQuestion(Question q) {
        questionField.setText(q.question);
        optionA.setText(q.answers[0]);
        optionB.setText(q.answers[1]);
        optionC.setText(q.answers[2]);
        optionD.setText(q.answers[3]);
    }

    public void nextQuestion() {
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
                    }
                }
            }

            if (count[0] == 6) {
                switchSceneButton.setVisible(true); // runs "switchToScore() on press"
                tempButton.setVisible(false);
            }

        });
    }
    //switches to the score screen
    public void switchToScore(ActionEvent event) throws IOException {
        // TODO: if you ever wanted to fix proper spagetti code well now is your chance buckaroo
        // have at yee
        if (optionA.isSelected()) { currentUser.data.questions[5].userAnswer = 0; }
        else if (optionA.isSelected()) { currentUser.data.questions[5].userAnswer = 1; }
        else if (optionA.isSelected()) { currentUser.data.questions[5].userAnswer = 2; }
        else { currentUser.data.questions[5].userAnswer = 3; }

        loadScene(event, "/quizgame/resource/scoreScreen.fxml");
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
                pageSelector(event, "settings");
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
            pageSelector(event, "settings");
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
