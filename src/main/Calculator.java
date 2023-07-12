package main;

import main.interfaces.ExpressionBuilder;
import main.interfaces.IOTool;
import main.interfaces.NumeralTranslator;
import main.interfaces.impl.ArabicNumeralTranslator;
import main.interfaces.impl.IOConsoleService;
import main.interfaces.impl.RomanNumeralTranslator;
import main.interfaces.impl.BuildExpressionService;

public class Calculator {
    public static void main(String[] args) {
        IOTool ioTool = new IOConsoleService();
        ExpressionBuilder expressionBuilder = new BuildExpressionService();
        NumeralTranslator numeralTranslator;
        ArithmeticExpression expression;
        try {
            expression = expressionBuilder.constructExpressionFromArrayInputStrings(ioTool.readAndSplit());
            int result = calculate(expression);
            if (expression.isRoman()) {
                numeralTranslator = new RomanNumeralTranslator();
            } else {
                numeralTranslator = new ArabicNumeralTranslator();
            }
            ioTool.write(numeralTranslator.translateToString(result));
        } catch (Exception e) {
            System.out.println(e);
            System.exit(-1);
        }
    }

    public static int calculate(ArithmeticExpression expression) throws Exception {
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
