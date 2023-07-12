package main.interfaces;

import main.models.ArithmeticExpression;

public interface CalculatorService {
    int calculate(ArithmeticExpression expression) throws Exception;
}
