package main.interfaces;

import main.ArithmeticExpression;

public interface ExpressionBuilder {
    ArithmeticExpression constructExpressionFromArrayInputStrings(String[] strs) throws Exception;
}
