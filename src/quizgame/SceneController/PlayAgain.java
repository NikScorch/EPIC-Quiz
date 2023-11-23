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
import java.util.Comparator;
import java.util.Objects;
import java.util.List;

public class PlayAgain {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private AnchorPane exitPane;
    @FXML
    private Label firstPlace, secondPlace, thirdPlace;
    //User currentUser;

    public void switchToSettings(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(Gui.class.getResource("/quizgame/SceneController/resource/settingsScreen.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void leaderBoardSettings() throws NoSuchAlgorithmException {

    /*    LoginManager.loadAllUsers();
        for (int i = 0; i < LoginManager.loadAllUsers().length; i++ ) {
            if (User.score[i] > User.score[i + 1]) {

            }
        }
    */
//        List<User> allUsers = List.of((LoginManager.loadAllUsers()));
//        allUsers.sort(Comparator.comparingInt(User::getScore).reversed());
//        if (!allUsers.isEmpty()) {
//            User firstPlaceUser = allUsers.get(0);
//            firstPlace.setText(firstPlaceUser.getUsername() + ": " + firstPlaceUser.getScore());
//
//            if (allUsers.size() > 1) {
//                User secondPlaceUser = allUsers.get(1);
//                secondPlace.setText(secondPlaceUser.getUsername() + ": " + secondPlaceUser.getScore());
//            }
//
//            if (allUsers.size() > 2) {
//                User thirdPlaceUser = allUsers.get(2);
//                thirdPlace.setText(thirdPlaceUser.getUsername() + ": " + thirdPlaceUser.getScore());
//            }
//        }
//        for(User u : LoginManager.loadAllUsers()) {
//            if(Quiz.score < ) {
//                firstPlace.setText(first);
//                secondPlace.setText(second);
//                thirdPlace.setText(third);
//            }
//        }

    }

    public void playAgain(ActionEvent event) throws IOException {
        HelloView.currentUser.saveSession();
        switchToSettings(event);
    }

    public void exit(ActionEvent event) {
        stage = (Stage) exitPane.getScene().getWindow();
        stage.close();
        LoginManager.saveUser(HelloView.currentUser);
    }

}
