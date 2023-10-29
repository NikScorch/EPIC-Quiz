module quizgame {

    requires javafx.controls;
    requires javafx.fxml;

    opens quizgame to javafx.fxml;
    exports quizgame;
    //opens quizgame.resource to javafx.fxml;



}
