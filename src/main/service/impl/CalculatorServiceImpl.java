package main.service.impl;

import main.service.CalculatorService;
import main.model.ArithmeticExpression;

public class CalculatorServiceImpl implements CalculatorService {
    public int calculate(ArithmeticExpression expression) throws Exception {
        int result = 0;
        switch (expression.getOperation()) {
            case '+':
                result = expression.getFirstInt() + expression.getSecondInt();
                break;
            case '-':
                result = expression.getFirstInt() - expression.getSecondInt();
                break;
            case '/':
                result = expression.getFirstInt() / expression.getSecondInt();
                break;
            case '*':
                result = expression.getFirstInt() * expression.getSecondInt();
                break;
        }
        if (result < 1 && expression.isRoman()) {
            throw new Exception("Roman numerals cannot be less than 1");
        }

        return result;
    }
}
