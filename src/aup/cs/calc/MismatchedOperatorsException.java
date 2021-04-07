package aup.cs.calc;

public class MismatchedOperatorsException extends Exception {

    public MismatchedOperatorsException(){
        super("MismatchedOperatorsException: mismatch between number of operators");
    }

    public MismatchedOperatorsException(String msg){
        super("MismatchedOperatorsException: " + msg);
    }
}
