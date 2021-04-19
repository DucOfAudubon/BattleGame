package aup.cs.games;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class ScoresPane extends BorderPane {
    private int score1 = 0;
    private int score2 = 0;
    private Text textSc1;
    private Text textSc2;
    private CardsPane cardsPane;

    /**
     * Create a BorderPane
     * Put the scores into texts
     * Make a button which, when clicked, calls the internal reset function
     * Stick it in the right spots in the BorderPane
     */
    public ScoresPane(){
        super();
        textSc1 = new Text("Player 1: " + getScore1());
        textSc2 = new Text("Player 2: " + getScore2());
        Button reset = new Button("Reset");
        reset.setOnAction(e -> resetInternal());
        setLeft(textSc1);
        setRight(textSc2);
        setCenter(reset);
    }

    /**
     * This increments the score of a winning party
     * It then redisplays the texts
     * @param winner
     */
    public void addPoint(int winner){
        switch(winner){
            case 1:
                setScore1(getScore1() + 1);
                break;
            case 2:
                setScore2(getScore2() + 1);
                break;
        }
        setText();
    }

    /**
     * This updates the texts so that they change in the display
     */
    private void setText(){
        textSc1.setText("Player 1: " + getScore1());
        textSc2.setText("Player 2: " + getScore2());
    }

    /**
     * This is a reset that a CardPane would call
     * There has to be a separate external and internal reset so that it doesn't get an infinite loop
     * So that external things can call a reset which doesn't call back on them
     */
    public void reset(){
        setScore1(0);
        setScore2(0);
        setText();
    }

    /**
     * Just calls the reset of the associated CardsPane
     * Since they'll be linked
     * Also calls its own reset just in case it doesn't get called elsewhere
     */
    private void resetInternal(){
        cardsPane.reset();
        reset();
    }

    public int getScore1() {
        return score1;
    }

    public int getScore2() {
        return score2;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }

    public void setScore2(int score2) {
        this.score2 = score2;
    }

    /**
     * Compares the two scores
     * @return 1 if score1 is higher, 2 if score2 is, 0 if it's a tie
     */
    public int getWinner() {
        if(score1 > score2){
            return 1;
        }
        else if(score2 > score1){
            return 2;
        }
        else{
            return 0;
        }
    }

    /**
     * This is the cardsPane that will get affected by the button
     * @param cardsPane
     */
    public void setCardsPane(CardsPane cardsPane){
        this.cardsPane = cardsPane;
    }
}
