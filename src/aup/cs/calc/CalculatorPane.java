package aup.cs.calc;

import javafx.beans.property.StringProperty;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;

public class CalculatorPane extends VBox{

    public CalculatorPane() {
        init();
    }

    private void init() {
        TextField input = new TextField();
        StringProperty inProperty = input.textProperty();
        Pane firstRow = new HBox(
                new InputButton("1", inProperty),
                new InputButton("2", inProperty),
                new InputButton("3", inProperty));

        Pane secondRow = new HBox(
                new InputButton("4", inProperty),
                new InputButton("5", inProperty),
                new InputButton("6", inProperty));

        Pane thirdRow = new HBox(
                new InputButton("7", inProperty),
                new InputButton("8", inProperty),
                new InputButton("9", inProperty));

        Pane fourthRow = new HBox(
                new InputButton("0", inProperty),
                new InputButton("+", inProperty),
                new InputButton("-", inProperty));

        Pane fifthRow = new HBox(
                new InputButton("*", inProperty),
                new InputButton("/", inProperty),
                new EqualButton(inProperty));

        Pane sixthRow = new HBox(
                new InputButton(" ", inProperty),
                new ClearButton(inProperty));

        getChildren().addAll(input, firstRow, secondRow, thirdRow, fourthRow, fifthRow, sixthRow);
    }
}
