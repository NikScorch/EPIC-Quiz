package quizgame.SceneController;

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
import javafx.stage.Stage;
import quizgame.Gui;
import quizgame.Question;
import quizgame.QuestionGetter;
import quizgame.SwitchSceneController;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Settings {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private Button tempButton, switchSceneButton, exitButton;
    @FXML
    private Label questionField, firstPlace, secondPlace, thirdPlace;
    @FXML
    private RadioButton optionA, optionB, optionC, optionD;
    double progress;

    public void switchToDifficulty(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(Gui.class.getResource("/quizgame/SceneController/resource/difficultyScreen.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSubject(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(Gui.class.getResource("/quizgame/SceneController/resource/subjectScreen.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToHello(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(Gui.class.getResource("/quizgame/SceneController/resource/hello-view.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToQuizRandom(ActionEvent event) throws IOException {
        //root = FXMLLoader.load(Objects.requireNonNull(Gui.class.getResource("resource/quizScreen.fxml")));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/quizgame/SceneController/resource/quizScreen.fxml"));
        root = loader.load();
        Quiz controller = loader.getController();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        controller.questionDisplayRandom();
    }
}
