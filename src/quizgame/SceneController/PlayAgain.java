package quizgame.SceneController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import quizgame.Gui;
import quizgame.User;
import java.io.IOException;
import java.util.Objects;

public class PlayAgain {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private AnchorPane exitPane;
    @FXML
    private Label firstPlace, secondPlace, thirdPlace;
    User currentUser;

    public void switchToSettings(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(Gui.class.getResource("/quizgame/SceneController/resource/settingsScreen.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void leaderBoardSettings(){
        firstPlace.setText("Michelle");
        secondPlace.setText("Darragh");
        thirdPlace.setText("this was a test");
    }

    public void playAgain(ActionEvent event) throws IOException {
        currentUser.saveSession();
        switchToSettings(event);
    }

    public void exit(ActionEvent event) {
        stage = (Stage) exitPane.getScene().getWindow();
        stage.close();
    }

}
