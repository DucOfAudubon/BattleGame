package testspace;

import aup.cs.calc.ClearButton;
import aup.cs.calc.EqualButton;
import aup.cs.calc.InputButton;
import javafx.beans.property.StringProperty;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

public class TestPane extends VBox{

    public TestPane() {
        init();
    }

    private void init() {
        Circle c = new Circle(20);
        ColorButton cb = new ColorButton(c);
        getChildren().addAll(c, cb);
    }
}
