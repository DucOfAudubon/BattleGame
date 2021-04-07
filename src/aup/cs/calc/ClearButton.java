package aup.cs.calc;

import javafx.beans.property.StringProperty;

public class ClearButton extends InputButton{

    /**
     * makes an InputButton that says clear
     * This constructor will call execute
     * but execute gets overwritten in this Class
     * Also, this button will be clicked by pressing the esc key
     * @param inProperty the textfield that will get edited
     * @param width the width of the button
     */
    public ClearButton(StringProperty inProperty, int width){
        super("Clear", inProperty, width);
        setCancelButton(true);
    }

    public ClearButton(StringProperty inProperty){
        this(inProperty, 50);
    }

    /**
     * This overrides the execute.
     * Instead of appending to the textfield, this deletes everything in it
     */
    @Override
    protected void execute() {
        inProperty.set("");
    }
}
