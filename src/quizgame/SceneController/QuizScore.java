package quizgame.SceneController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import quizgame.User;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class QuizScore {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Label scoreLabel;

    public void switchToPlayagain(ActionEvent event) throws IOException, NoSuchAlgorithmException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/quizgame/SceneController/resource/playagainScreen.fxml"));
        root = loader.load();
        PlayAgain controller = loader.getController();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        controller.leaderBoardSettings();
    }
    public void displayScore() {
        scoreLabel.setText(String.valueOf(User.score));
    }

}
