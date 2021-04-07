package aup.cs.calc;

import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class InputButton extends Button{
    private String value;
    protected StringProperty inProperty;

    public InputButton(String value, StringProperty inProperty){
        super(value);
        this.value = value;
        this.inProperty = inProperty;
        setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                execute();
            }
        });
    }

    protected void execute() {
        inProperty.set(inProperty.get() + value);
    }
}
