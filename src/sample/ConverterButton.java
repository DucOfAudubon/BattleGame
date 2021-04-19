package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.beans.property.StringProperty;
import javafx.event.EventHandler;
import javafx.event.Event;

public class ConverterButton extends Button {
    private StringProperty cProperty;
    private StringProperty fProperty;

    public ConverterButton(StringProperty cProperty, StringProperty fProperty) {
        super("Convert");
        this.cProperty = cProperty;
        this.fProperty = fProperty;
        setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                convert();
            }
        });
    }

    private void convert() {
        String cval = cProperty.get();
        String fval = fProperty.get();
        if(cval.length() > 0){
            double cdoub = Double.parseDouble(cval);
            double fdoub = 9 * cdoub / 5 + 32.0;
            fProperty.set(String.valueOf(fdoub));
        }
        else if(fval.length() > 0){
            double fdoub = Double.parseDouble(fval);
            double cdoub = (fdoub - 32) * 5 / 9;
            cProperty.set(String.valueOf(cdoub));
        }
    }
}