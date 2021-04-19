package testspace;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

import static javafx.scene.input.KeyCode.R;

public class ColorButton extends Button {
    private Circle c;

    public ColorButton(Circle c) {
        super("Change Color");
        this.c = c;
        c.getParent().setOnKeyPressed(keyEvent -> {
            switch (keyEvent.getCode()) {
                case R:
                    c.setStyle("-fx-background-color: red");
            }
        });
    }
}
