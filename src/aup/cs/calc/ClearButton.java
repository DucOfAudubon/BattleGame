package aup.cs.calc;

import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ClearButton extends InputButton{

    public ClearButton(StringProperty inProperty){
        super("Clear", inProperty);
        setCancelButton(true);
    }

    @Override
    protected void execute() {
        inProperty.set("");
    }
}
