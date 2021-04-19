package aup.cs.games;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
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
    private BorderPane playedCards = new BorderPane();
    private ImageView mainDeck = new ImageView(deckPile);
    private Text display = new Text("");
    int winner;

    public CardsPane(ScoresPane scoresPane) {
        super();
        this.scoresPane = scoresPane;
        playedCards.setLeft(deck1);
        playedCards.setRight(deck2);
        playedCards.setOpacity(0);
        mainDeck.setOnMouseClicked(event -> play());
        getChildren().addAll(display, playedCards, mainDeck);
    }

    /**
     * Draw 2 cards from the deck
     * set them into the images on the table
     * Make the cards opaque, so that on the first draw they show up in their piles
     * Adjust the points of the players in the scoresPane
     * Then, if the deck is now empty, make it transparent
     * set the next click anywhere to end the game
     */
    private void play() {
        Card card1 = deck.draw();
        deck1.setImage(card1.getCardFront());
        Card card2 = deck.draw();
        deck2.setImage(card2.getCardFront());
        playedCards.setOpacity(100);
        if(card1.getValue() > card2.getValue()){
            scoresPane.addPoint(1);
        }
        else if(card1.getValue() < card2.getValue()){
            scoresPane.addPoint(2);
        }
        if(deck.cards.size() == 0) {
            mainDeck.setOpacity(0);
            setOnMouseClicked(event -> endGame());
            scoresPane.setOnMouseClicked(event -> endGame());
            mainDeck.setOnMouseClicked(event -> {});
        }
    }

    /**
     * Get the winner from scoresPane
     * Announce who won
     * Set the text to actually appear
     * Set the played card piles to disappear
     * Set the mouse to be clicked anywhere to reset the game
     */
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
        setOnMouseClicked(event -> reset());
    }

    /**
     * Make a new deck to refill and reshuffle the deck
     * Make it visible again
     * Delete the text
     * Reset the scores
     * Make the dealt cards disappear
     * Reset the click consequences
     */
    public void reset() {
        deck = new Deck();
        mainDeck.setOpacity(100);
        display.setText("");
        scoresPane.reset();
        playedCards.setOpacity(0);
        mainDeck.setOnMouseClicked(event -> play());
        scoresPane.setOnMouseClicked(event -> {});
        setOnMouseClicked(event -> {});
    }

    /**
     * Honestly, this probably didn't have to be a nested class
     * But I wanted to take the chance to make these
     */
    private class Deck {
        LinkedList<Card> cards = new LinkedList<>(); //A list of Cards

        /**
         * Fill the deck with cards based on ints
         */
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

    /**
     * Probably also did not need to be a nested class
     * But fun
     */
    public class Card extends Pane {
        private int value;
        private Image cardFront;
        private Image cardBack = new Image("155.gif");

        /**
         * Set the value of the card to be from 1-13
         * Make the cardFront the correct image
         * @param value
         */
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
