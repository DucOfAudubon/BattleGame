package aup.cs.games;

import javafx.scene.layout.BorderPane;

public class GamePane extends BorderPane {
    ScoresPane scoresPane = new ScoresPane();
    CardsPane cardsPane = new CardsPane(scoresPane);

    public GamePane(){
        super();
        scoresPane.setCardsPane(cardsPane);
        setTop(scoresPane);
        setCenter(cardsPane);
    }
}
