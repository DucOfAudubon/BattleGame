package aup.cs.calc;

import javafx.beans.property.StringProperty;

import java.util.ArrayList;
import java.util.Iterator;

public class EqualButton extends InputButton{

    public EqualButton(StringProperty inProperty){
        super("=", inProperty);
        setDefaultButton(true);
    }

    @Override
    protected void execute() {
        String inVal = inProperty.get();
        ArrayList<String> split = new ArrayList<>();
        String[] expression = inVal.split(" ");
        for(String element : expression){
            split.add(element);
        }
        System.out.println("At First: " + split);
        Double result = calculate(split);
        inProperty.set(result.toString());
    }

    private double calculate(ArrayList<String> split){
        ArrayList<Double> stack = new ArrayList<>();
        String operators = "[*/+-]";
        for(String element : split) {
            if(element.matches(operators)){
                System.out.println(element);
                operate(element, stack);
            }
            else{
                stack.add(Double.valueOf(element));
                System.out.println(stack);
            }
        }
        return stack.get(0);
    }

    private void operate(String operator, ArrayList<Double> stack){
        double result = 0.0;
        Double operandOne = stack.get(stack.size()-2);
        Double operandTwo = stack.get(stack.size()-1);
        switch(operator){
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
        stack.remove(stack.size()-2);
        stack.remove(stack.size()-1);
        stack.add(result);
    }

    /**
     * This method is probably not the best way to do things
     * I'm keeping it for legacy
     * But I'm switching to a stack method
     */
    /** private int operator(String operator, ArrayList<String> split, int i){
        double operandOne;
        double operandTwo;
        Double result;
        String resultStr;
        switch(operator){
            case "*":
                operandOne = Double.parseDouble(split.get(i - 2));
                operandTwo = Double.parseDouble(split.get(i - 1));
                result = operandOne * operandTwo;
                resultStr = result.toString();
                split.set(i, resultStr);
                split.remove(i - 1);
                split.remove(i - 2);
                split.add("");
                split.add("");
                i--;
                i--;
                break;
            case "/":
                operandOne = Double.parseDouble(split.get(i - 2));
                operandTwo = Double.parseDouble(split.get(i - 1));
                result = operandOne / operandTwo;
                resultStr = result.toString();
                split.set(i, resultStr);
                split.remove(i - 1);
                split.remove(i - 2);
                split.add("");
                split.add("");
                i--;
                i--;
                break;
            case "+":
                operandOne = Double.parseDouble(split.get(i - 2));
                operandTwo = Double.parseDouble(split.get(i - 1));
                result = operandOne + operandTwo;
                resultStr = result.toString();
                split.set(i, resultStr);
                split.remove(i - 1);
                split.remove(i - 2);
                split.add("");
                split.add("");
                i--;
                i--;
                break;
            case "-":
                operandOne = Double.parseDouble(split.get(i - 2));
                operandTwo = Double.parseDouble(split.get(i - 1));
                result = operandOne - operandTwo;
                resultStr = result.toString();
                split.set(i, resultStr);
                split.remove(i - 1);
                split.remove(i - 2);
                split.add("");
                split.add("");
                i--;
                i--;
                break;
            default:
                i++;
                break;
        }
        return i;
    }
     */

    /**
     * Removes the spaces from each element of the array
     * Now unnecessary as, with reverse Polish, there should always be spaces between the elements
     * so I can just split by the spaces
     * I'm just going to leave it here as legacy
     */
    private void removeSpaces(ArrayList<String> expression){
        Iterator itr = expression.iterator();
        while (itr.hasNext()) {
            String str = (String)itr.next();
            if (str.equals(" ")) {
                itr.remove();
            }
        }
    }
}
