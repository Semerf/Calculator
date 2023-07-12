package main;

import main.services.CalculatorService;
import main.services.ExpressionBuilderService;
import main.services.IOToolService;
import main.services.NumeralTranslatorService;
import main.services.impl.ArabicNumeralTranslatorServiceImpl;
import main.services.impl.BuildExpressionServiceImpl;
import main.services.impl.CalculatorServiceImpl;
import main.services.impl.IOConsoleServiceImpl;
import main.services.impl.RomanNumeralTranslatorServiceImpl;
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
