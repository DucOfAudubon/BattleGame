package aup.cs.games;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class ScoresPane extends HBox {
    private int score1 = 0;
    private int score2 = 0;
    private Text textSc1;
    private Text textSc2;
    private Text gap1 = new Text("\t\t");
    private Text gap2 = new Text("\t\t");
    private CardsPane cardsPane;

    public ScoresPane(){
        super();
        textSc1 = new Text("Player 1: " + getScore1());
        textSc2 = new Text("Player 2: " + getScore2());
        Button reset = new Button("Reset");
        reset.setOnAction(e -> resetInternal());
        getChildren().addAll(textSc1, gap1, reset, gap2, textSc2);
    }

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

    private void setText(){
        textSc1.setText("Player 1: " + getScore1());
        textSc2.setText("Player 2: " + getScore2());
    }

    public void reset(){
        setScore1(0);
        setScore2(0);
        setText();
    }

    private void resetInternal(){
        cardsPane.reset();
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

    public void setCardsPane(CardsPane cardsPane){
        this.cardsPane = cardsPane;
    }
}
