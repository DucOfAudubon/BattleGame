package aup.cs.games;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.Collections;
import java.util.LinkedList;

public class CardsPane extends VBox {
    private ScoresPane scoresPane;
    private Deck deck = new Deck();
    private Image pile1 = new Image("153.gif");
    private Image pile2 = new Image("154.gif");
    private Image deckPile = new Image("155.gif");
    private ImageView deck1 = new ImageView(pile1);
    private ImageView deck2 = new ImageView(pile2);
    private HBox playedCards = new HBox(deck1, deck2);
    private ImageView mainDeck = new ImageView(deckPile);
    private Text display = new Text("");
    int winner;

    public CardsPane(ScoresPane scoresPane) {
        super();
        this.scoresPane = scoresPane;
        playedCards.setOpacity(0);
        mainDeck.setOnMouseClicked(event -> play());
        getChildren().addAll(display, playedCards, mainDeck);
    }

    private void play() {
        Card card1 = deck.draw();
        deck1.setImage(card1.getCardFront());
        Card card2 = deck.draw();
        deck2.setImage(card2.getCardFront());
        if(deck.cards.size() == 0) {
            mainDeck.setOpacity(0);
            setOnMouseClicked(event -> endGame());
            mainDeck.setOnMouseClicked(event -> {});
            return;
        }
        playedCards.setOpacity(100);
        if(card1.getValue() > card2.getValue()){
            scoresPane.addPoint(1);
        }
        else if(card1.getValue() < card2.getValue()){
            scoresPane.addPoint(2);
        }
    }

    private void endGame() {
        winner = scoresPane.getWinner();
        if(winner == 0){
            display.setText("Amazing! It's a tie! Please click on the screen to play again.");
        }
        else{
            display.setText("Player " + winner + " has won! Please click on the screen to play again.");
        }
        display.setOpacity(100);
        playedCards.setOpacity(0);
        mainDeck.setOpacity(0);
        setOnMouseClicked(event -> reset());
    }

    public void reset() {
        deck = new Deck();
        mainDeck.setOpacity(100);
        display.setText("");
        scoresPane.reset();
        playedCards.setOpacity(0);
        mainDeck.setOnMouseClicked(event -> play());
        setOnMouseClicked(event -> {});
    }

    private class Deck {
        LinkedList<Card> cards = new LinkedList<>();

        public Deck() {
            for(int i = 1; i < 53; i++) {
                cards.add(new Card(i));
            }
            Collections.shuffle(cards);
        }

        public Card draw(){
            return cards.pop();
        }
    }

    public class Card extends Pane {
        private int value;
        private Image cardFront;
        private Image cardBack = new Image("155.gif");

        public Card(int value){
            this.value = (value - 1) % 13;
            this.value++;
            String imgPath;
            switch(value){
                case 1,2,3,4,5,6,7,8,9:
                    imgPath = "10" + value + ".gif";
                    break;
                default:
                    imgPath = "1" + value + ".gif";
            }
            this.cardFront = new Image(imgPath);
        }

        public Image getCardFront(){
            return cardFront;
        }

        public Image getCardBack() {
            return cardBack;
        }

        public int getValue(){
            return value;
        }
    }
}
