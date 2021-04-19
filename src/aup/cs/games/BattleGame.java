package aup.cs.games;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class BattleGame extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane gamePane = new GamePane();
        gamePane.setStyle("-fx-background-color: #277714");
        Scene scene = new Scene(gamePane, 1000, 600);
        primaryStage.setTitle("WARRRRR!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
