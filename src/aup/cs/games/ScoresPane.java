package aup.cs.games;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class ScoresPane extends HBox {
    private int score1 = 0;
    private int score2 = 0;
    private Text textSc1;
    private Text textSc2;

    public ScoresPane(){
        super();
        this.textSc1 = new Text("Player 1: " + getScore1());
        this.textSc2 = new Text("Player 2: " + getScore2());
        Text space = new Text("\t\t\t\t\t");
        Button reset = new Button("Reset");
        reset.setOnAction(e -> reset());
        getChildren().addAll(textSc1, space, reset, space, textSc2);
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
            return score1;
        }
        else if(score2 > score1){
            return score2;
        }
        else{
            return 0;
        }
    }
}
