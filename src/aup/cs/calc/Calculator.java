package aup.cs.calc;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;

public class Calculator extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new CalculatorPane();
        Scene scene = new Scene(pane, 180, 200);
        primaryStage.setTitle("JavaFX Calculator"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    public static void main(String[] args){
        launch(args);
    }
}
