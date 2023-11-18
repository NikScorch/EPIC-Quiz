package quizgame.SceneController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import quizgame.SwitchSceneController;

import java.io.IOException;

public class Score {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Label questionField, firstPlace, secondPlace, thirdPlace;
    public void switchToPlayagain(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("resource/playagainScreen.fxml"));
        root = loader.load();

        Score controller = loader.getController();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        controller.leaderBoardSettings();
    }

    public void leaderBoardSettings(){
        firstPlace.setText("Michelle");
        secondPlace.setText("Darragh");
        thirdPlace.setText("this was a test");
    }

}
