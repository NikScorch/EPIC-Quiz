package quizgame.SceneController;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import quizgame.Gui;
import quizgame.User;

import java.io.IOException;
import java.util.Objects;

public class QuizDifficulty {
    private Stage stage;
    private Scene scene;
    private Parent root;
    double progress;
    //static User currentUser;
    public void switchToQuizEasy(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/quizgame/SceneController/resource/quizScreen.fxml"));
        root = loader.load();
        Quiz controller = loader.getController();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        //currentUser.data.questions = QuestionGetter.getAllQuestionsByFilter(quizgame.Difficulty.EASY);
        //controller.questionDisplay();
        controller.questionDisplayDifficulty(quizgame.Difficulty.EASY);
    }

    public void switchToQuizMedium(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/quizgame/SceneController/resource/quizScreen.fxml"));
        root = loader.load();
        Quiz controller = loader.getController();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        controller.questionDisplayDifficulty(quizgame.Difficulty.MEDIUM);
    }

    public void switchToQuizHard(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/quizgame/SceneController/resource/quizScreen.fxml"));
        root = loader.load();
        Quiz controller = loader.getController();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        controller.questionDisplayDifficulty(quizgame.Difficulty.HARD);
    }

    public void switchToSettings(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(Gui.class.getResource("/quizgame/SceneController/resource/settingsScreen.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
