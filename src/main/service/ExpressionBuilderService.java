package main.service;

import main.model.ArithmeticExpression;

public interface ExpressionBuilderService {
    ArithmeticExpression constructExpressionFromArrayInputStrings(String[] strs) throws Exception;
}
