package quizgame.SceneController;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import quizgame.*;
import java.io.IOException;
import java.util.Objects;

public class Subject {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToSettings(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(Gui.class.getResource("/quizgame/SceneController/resource/settingsScreen.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToQuizMaths(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/quizgame/SceneController/resource/quizScreen.fxml"));
        root = loader.load();
        Quiz controller = loader.getController();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        controller.questionDisplayTopic(Topic.DISCRETE_MATHS);
    }
    public void switchToQuizCompOrg(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/quizgame/SceneController/resource/quizScreen.fxml"));
        root = loader.load();
        Quiz controller = loader.getController();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        controller.questionDisplayTopic(Topic.COMP_ORG);
    }

    //when computer science is selected, it switches to the quiz screen and calls the question display method
    public void switchToQuizCompSci(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/quizgame/SceneController/resource/quizScreen.fxml"));
        root = loader.load();
        Quiz controller = loader.getController();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        controller.questionDisplayTopic(Topic.COMPUTER_SCIENCE);
    }

}
