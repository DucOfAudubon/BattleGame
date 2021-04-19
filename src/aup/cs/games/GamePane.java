package aup.cs.games;

import javafx.scene.layout.VBox;

public class GamePane extends VBox {
    ScoresPane scoresPane = new ScoresPane();
    CardsPane cardsPane = new CardsPane(scoresPane);

    public GamePane(){
        super();
        scoresPane.setCardsPane(cardsPane);
        getChildren().addAll(scoresPane, cardsPane);
    }
}
