package quizgame.SceneController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import quizgame.LoginManager;
import quizgame.User;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

public class HelloView {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    TextField usernameTextField;
    @FXML
    PasswordField passwordTextField;
    static User currentUser;


    /** Each scene requires a controller, the classes in the SceneController class are all connected to each scene designed.
     * Each of these controllers control the logic and instructions which the scene follows. **/


    // this is the login method that calls the login manager and stores the user details.
    // it also handles wrong input and displays an error message accordingly.
    public void login(ActionEvent event) throws IOException, NoSuchAlgorithmException {
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error!");
        alert.setHeaderText("User does not exist.");
        alert.setContentText("Invalid username, please register or recheck your username.");

        if (LoginManager.userExists(username)) {
            currentUser = LoginManager.loadUser(username);
            if(currentUser.verifyPassword(password)) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/quizgame/SceneController/resource/settingsScreen.fxml"));
                root = loader.load();
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

    // if the user decides to register, then it switches to the register scene.
    public void switchToRegister(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/quizgame/SceneController/resource/registerScreen.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
