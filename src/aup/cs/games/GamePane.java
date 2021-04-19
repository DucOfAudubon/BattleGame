package aup.cs.games;

import javafx.scene.layout.VBox;

public class GamePane extends VBox {

    public GamePane(){
        super();
        ScoresPane scoresPane = new ScoresPane();
        CardsPane cardsPane = new CardsPane(scoresPane);
        getChildren().addAll(scoresPane, cardsPane);
    }
}
