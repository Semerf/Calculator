package main;

import main.interfaces.CalculatorService;
import main.interfaces.ExpressionBuilderService;
import main.interfaces.IOToolService;
import main.interfaces.NumeralTranslatorService;
import main.interfaces.impl.*;
import main.models.ArithmeticExpression;

public class Main {
    public static void main(String[] args) {
        IOToolService ioTool = new IOConsoleServiceImpl();
        ExpressionBuilderService expressionBuilder = new BuildExpressionServiceImpl();
        CalculatorService calculator = new CalculatorServiceImpl();
        NumeralTranslatorService numeralTranslator;
        ArithmeticExpression expression;
        try {
            expression = expressionBuilder.constructExpressionFromArrayInputStrings(ioTool.readAndSplit());
            int result = calculator.calculate(expression);
            if (expression.isRoman()) {
                numeralTranslator = new RomanNumeralTranslatorServiceImpl();
            } else {
                numeralTranslator = new ArabicNumeralTranslatorServiceImpl();
            }
            ioTool.write(numeralTranslator.translateToString(result));
        } catch (Exception e) {
            System.out.println(e);
            System.exit(-1);
        }
    }
}
