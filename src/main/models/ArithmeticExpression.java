package main.models;

public class ArithmeticExpression {
    private final int firstInt;
    private final int secondInt;
    private final char operation;
    private final boolean isRoman;

    public ArithmeticExpression(int firstInt, int secondInt, char operation, boolean isRoman) {
        this.firstInt = firstInt;
        this.secondInt = secondInt;
        this.operation = operation;
        this.isRoman = isRoman;
    }

    public int getFirstInt() {
        return firstInt;
    }

    public int getSecondInt() {
        return secondInt;
    }

    public char getOperation() {
        return operation;
    }

    public boolean isRoman() {
        return isRoman;
    }
}
