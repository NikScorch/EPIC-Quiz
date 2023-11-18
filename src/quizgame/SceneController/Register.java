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
import quizgame.Gui;
import quizgame.LoginManager;
import quizgame.SwitchSceneController;
import quizgame.User;

import java.io.IOException;
import java.util.Objects;

public class Register {

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    TextField usernameTextField, registerUserTextField;
    @FXML
    PasswordField passwordTextField, registerPasswordField, reEnterPasswordField;
    User currentUser;

    public void register(ActionEvent event) throws IOException {
        String username = registerUserTextField.getText();
        String password = registerPasswordField.getText();
        String reEnterPassword = reEnterPasswordField.getText();
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error!");
        alert.setHeaderText("Passwords do not match");
        alert.setContentText("Re-enter your password and check for spelling errors");

        if(password.equals(reEnterPassword)) {
            LoginManager.registerUser(username, password);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("resource/hello-view.fxml"));
            root = loader.load();
            Register controller = loader.getController();
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else{
            alert.showAndWait();
        }
    }

    public void switchToHello(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(Gui.class.getResource("resource/hello-view.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
