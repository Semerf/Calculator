package main.service;

import main.model.ArithmeticExpression;

public interface CalculatorService {
    int calculate(ArithmeticExpression expression) throws Exception;
}
