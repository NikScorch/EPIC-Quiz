package quizgame;

import javafx.application.Application;
//import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import java.io.IOException;

public class Gui extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Gui.class.getResource("SceneController/resource/hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 690, 540);
        stage.setTitle("Luna-Quiz");
        stage.getIcons().add(new Image(Gui.class.getResourceAsStream("resource/EpicQuizLogoReal.png")));
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }

    public static void main(String[] args) {
        QuestionGetter.loadQuestions();
        launch();
    }
}
