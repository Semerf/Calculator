package main.services;

import main.models.ArithmeticExpression;

public interface ExpressionBuilderService {
    ArithmeticExpression constructExpressionFromArrayInputStrings(String[] strs) throws Exception;
}
