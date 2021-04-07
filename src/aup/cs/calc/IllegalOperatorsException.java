package aup.cs.calc;

public class IllegalOperatorsException extends Exception {

    public IllegalOperatorsException(){
        super("IllegalOperatorsException: error with operators");
    }

    public IllegalOperatorsException(String msg){
        super("IllegalOperatorsException: " + msg);
    }
}
