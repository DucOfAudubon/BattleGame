package aup.cs.calc;

import javafx.beans.property.StringProperty;

import java.util.ArrayList;

public class EqualButton extends InputButton {

    /**
     * Makes an InputButton with an =
     * Overrides execute, so different execute will be called
     * Also, pressing the enter key will click this button
     * @param inProperty textfield to be evaluated and changed
     * @param width how wide you want the damn button, duh
     */
    public EqualButton(StringProperty inProperty, int width) {
        super("=", inProperty, width);
        setStyle("-fx-background-color: B3B3B3");
        setDefaultButton(true);
    }

    public EqualButton(StringProperty inProperty) {
        this(inProperty, 35);
    }

    /**
     * This method occurs when the button is clicked
     * It splits the contents of the textfield by spaces
     * It then calculates the result of the input of the textfield by calling calculate
     * Last, it takes the result of that calculate and puts in into the textfield
     */
    @Override
    protected void execute() throws IllegalOperatorsException{
        String inVal = inProperty.get();
        ArrayList<String> split = new ArrayList<>();
        String[] expression = inVal.split(" ");
        for (String element : expression) {
            split.add(element);
        }
        //Checks if everything in the input is a valid input character
        String unacceptables = ".*[^0123456789.*/+-].*";
        for(String element : split) {
            if (element.matches(unacceptables)) {
                throw new IllegalOperatorsException("Input includes illegal character");
            }
        }
        Double result = 0.0;
        String resStr = "";
        try {
            result = calculate(split);
            resStr = result.toString();
            inProperty.set(resStr);
        } catch (MismatchedOperatorsException moe) {
            System.err.println("Mismatched Operators Exception: " + moe.getMessage());
        }
    }

    /**
     * Taking the input from the textfield as an ArrayList of strings, it outputs a single Double (ha)
     * Does so by calling operate on every operator
     * @param split the textfield input, in ArrayList form
     * @return a single Double that is the result of the input
     * @throws MismatchedOperatorsException if there are too many or too few operators for the operands
     */
    private double calculate(ArrayList<String> split) throws MismatchedOperatorsException {
        ArrayList<Double> stack = new ArrayList<>();
        String operators = "[*/+-]";
        //Runs each operator successively
        //If it's not an operator, it adds the result to the stack, since it must be an operand
        //Honestly, this might be too much method delegation, but ah well
        for (String element : split) {
            if (element.matches(operators)) {
                operate(element, stack);
            }
            else {
                stack.add(Double.valueOf(element));
            }
        }
        //Gets the first (and theoretically only) result of the stack
        //if it's not the only member of the stack, it should throw an exception
        if(stack.size() > 1){
            throw new MismatchedOperatorsException("Not enough operators for the operands");
        }
        return stack.get(0);
    }

    private void operate(String operator, ArrayList<Double> stack) throws MismatchedOperatorsException {
        Double result = 0.0;
        if (stack.size() < 2) {
            throw new MismatchedOperatorsException("Not enough operands for the operators");
        }
        //The operands are going to be the last two things on the stack
        Double operandOne = stack.get(stack.size() - 2);
        Double operandTwo = stack.get(stack.size() - 1);
        switch (operator) {
            case "*":
                result = operandOne * operandTwo;
                break;
            case "/":
                result = operandOne / operandTwo;
                break;
            case "+":
                result = operandOne + operandTwo;
                break;
            case "-":
                result = operandOne - operandTwo;
                break;
        }
        //Remove the operands (gotta be careful which order you do it in!
        stack.remove(stack.size() - 2);
        stack.remove(stack.size() - 1);
        //Add the result to the stack
        stack.add(result);
    }
}
