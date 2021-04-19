package sample;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.beans.property.StringProperty;

public class ConvertingPane extends VBox {

    public ConvertingPane() {
        init();
    }

    private void init() {
        Circle c = new Circle(75, 75, 10);
        HBox buttons = new HBox();
        MoveButton up = new MoveButton();


        TextField farenheit = new TextField();
        Pane hpane = new HBox();
        Text ftext = new Text("Farenheit: ");
        StringProperty fProperty = farenheit.textProperty();

        getChildren().addAll(ftext, farenheit);
    }
}