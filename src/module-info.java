module EPIC.Quiz {
    requires javafx.controls;
    requires javafx.fxml;
    
    opens quizgame to javafx.fxml;
    exports quizgame;
}
