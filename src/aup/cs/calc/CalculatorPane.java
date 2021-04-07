package aup.cs.calc;

import javafx.beans.property.StringProperty;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;

public class CalculatorPane extends VBox{

    public CalculatorPane() {
        init();
    }

    private void init() {
        TextField input = new TextField(); //This'll be where the input AND output go. Efficiency
        StringProperty inProperty = input.textProperty();
        //To be honest, I'm not thrilled with the setup here, but it works and it's not hideous
        //Also, using rows means that when I add them all together later, I only have to call the rows, not everything
        Pane firstRow = new HBox(
                new InputButton("1", inProperty, 60),
                new InputButton("2", inProperty, 60),
                new InputButton("3", inProperty, 60));

        Pane secondRow = new HBox(
                new InputButton("4", inProperty, 60),
                new InputButton("5", inProperty, 60),
                new InputButton("6", inProperty, 60));

        Pane thirdRow = new HBox(
                new InputButton("7", inProperty, 60),
                new InputButton("8", inProperty, 60),
                new InputButton("9", inProperty, 60));

        Pane fourthRow = new HBox(
                new InputButton("0", inProperty, 60),
                new InputButton("+", inProperty, 60),
                new InputButton("-", inProperty, 60));

        Pane fifthRow = new HBox(
                new InputButton("*", inProperty, 60),
                new InputButton("/", inProperty, 60),
                new EqualButton(inProperty, 60));

        Pane sixthRow = new HBox(
                new InputButton(" ", inProperty, 60),
                new ClearButton(inProperty, 120));

        getChildren().addAll(input, firstRow, secondRow, thirdRow, fourthRow, fifthRow, sixthRow);
    }
}
