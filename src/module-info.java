module EPIC.Quiz {

    requires javafx.controls;
    requires javafx.fxml;



    opens quizgame to javafx.fxml;
    exports quizgame;
    //exports quizgame.resource;
    opens quizgame.resource to javafx.fxml;
}
