package quizgame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class switchSceneController implements Initializable {
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
    double progress;

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
    public void switchToQuiz(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(Gui.class.getResource("resource/quizScreen.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void exit(ActionEvent event) {
        stage = (Stage) exitPane.getScene().getWindow();
        stage.close();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void increaseProgress() {
        progress += 0.167;
        progressBar.setProgress(progress);

    }
}
