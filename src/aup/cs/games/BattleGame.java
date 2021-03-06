package aup.cs.games;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class BattleGame extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane gamePane = new GamePane();
        gamePane.setStyle("-fx-background-color: #277714"); //Like a card table
        Scene scene = new Scene(gamePane, 350, 250);
        primaryStage.setTitle("WARRRRR!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
