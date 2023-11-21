package quizgame.SceneController;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Score {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToPlayagain(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/quizgame/SceneController/resource/playagainScreen.fxml"));
        root = loader.load();
        PlayAgain controller = loader.getController();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        controller.leaderBoardSettings();
    }
}
