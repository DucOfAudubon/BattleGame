package aup.cs.calc;

import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class InputButton extends Button{
    private final String value;
    protected StringProperty inProperty;

    /**
     * So, it's gonna make a button
     * and when you click that button, it appends the "value" of that button to the textfield
     * that execute may get overwritten for other uses of input
     * @param value this is what's on the button
     * @param inProperty this is the textfield
     * @param width how wide you want your button. Shocking that this isn't a default constructor option for button
     */
    public InputButton(String value, StringProperty inProperty, int width){
        super(value);
        this.value = value;
        this.inProperty = inProperty;
        setMinWidth(width);
        setStyle("-fx-background-color: #404040; -fx-text-fill: #ffffff; -fx-border-color: #282828");
        setOnAction(event -> {
            try{
                execute();
            } catch (IllegalOperatorsException ioe){
                System.err.println("Illegal Operators Detected: " + ioe.getMessage());
            }
        });
    }

    public InputButton(String value, StringProperty inProperty){
        this(value, inProperty, 30);
    }

    /**
     * Appends the value of the button to the associated textfield
     * throws IllegalOperatorsException just because subclasses might
     */
    protected void execute() throws IllegalOperatorsException{
        inProperty.set(inProperty.get() + value);
    }
}
