package main.interfaces;

import main.models.ArithmeticExpression;

public interface ExpressionBuilderService {
    ArithmeticExpression constructExpressionFromArrayInputStrings(String[] strs) throws Exception;
}
