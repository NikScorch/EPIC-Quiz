package quizgame;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Cli {
   // public static void main(String[] args) {
     //   System.out.println("Hello World");
       // User u = new User();
        
       // u.answeredQuestions[0] = QuestionGetter.getRandomQuestion();

    //}

    public class Main extends Application {

        public static void main(String[] args) {
            launch(args);
        }

        @Override
        //public void start(Stage arg0) throws Exception {
            // TODO Auto-generated method stub
        //    throw new UnsupportedOperationException("Unimplemented method 'start'");    
        //}
        public void start(Stage primaryStage) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("mainpage.fxml"));
                Scene scene = new Scene(root);
                //scene.getStylesheets().add(getClass().getResource(""));
                primaryStage.setScene(scene);
                primaryStage.show();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        


    }


}