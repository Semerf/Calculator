package main;

import main.service.CalculatorService;
import main.service.ExpressionBuilderService;
import main.service.IOToolService;
import main.service.NumeralTranslatorService;
import main.service.impl.ArabicNumeralTranslatorServiceImpl;
import main.service.impl.BuildExpressionServiceImpl;
import main.service.impl.CalculatorServiceImpl;
import main.service.impl.IOConsoleServiceImpl;
import main.service.impl.RomanNumeralTranslatorServiceImpl;
import main.model.ArithmeticExpression;

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
