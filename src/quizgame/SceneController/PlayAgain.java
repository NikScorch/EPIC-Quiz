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
import quizgame.LoginManager;
import quizgame.User;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Objects;

public class PlayAgain {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private AnchorPane exitPane;
    @FXML
    private Label firstPlace, secondPlace, thirdPlace;


    /** This scene controller handles the final play again screen where the user can choose to either exit the application,
     * or play the game again.
     * this also handles the leader board settings. **/


    // if play again is selected, the user is taken back to the settings scene to chose their preferred game mode.
    public void switchToSettings(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(Gui.class.getResource("/quizgame/SceneController/resource/settingsScreen.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    //all users are loaded with their saved data, the top 3 scores are loaded and displayed.
    public void leaderBoardSettings() throws NoSuchAlgorithmException {

        User[] user = LoginManager.loadAllUsers();
        Arrays.sort(user, (o1, o2) -> Integer.compare(o2.getScore(), o1.getScore()));
        if (user.length > 0) {
            firstPlace.setText(user[0].getUsername());
        }
        if (user.length > 1) {
            secondPlace.setText(user[1].getUsername());
        }
        if (user.length > 2) {
            thirdPlace.setText(user[2].getUsername());
        }
    }

    // if user decides to exit application, the application ends.
    public void exit(ActionEvent event) {
        stage = (Stage) exitPane.getScene().getWindow();
        stage.close();
        LoginManager.saveUser(HelloView.currentUser);
    }

}
