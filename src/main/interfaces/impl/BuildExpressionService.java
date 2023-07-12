package main.interfaces.impl;

import main.interfaces.ExpressionBuilder;
import main.interfaces.NumeralTranslator;
import main.ArithmeticExpression;

public class BuildExpressionService implements ExpressionBuilder {
    @Override
    public ArithmeticExpression constructExpressionFromArrayInputStrings(String[] InputLines) throws Exception {
        boolean isRoman;
        int firstInt;
        int secondInt;
        char operation;
        NumeralTranslator numeralTranslator;
        if (isRomanCheck(InputLines[0].getBytes()[0])) {
            isRoman = true;
            numeralTranslator = new RomanNumeralTranslator();
        } else if (isArabicCheck(InputLines[0].getBytes()[0])) {
            isRoman = false;
            numeralTranslator = new ArabicNumeralTranslator();
        } else {
            throw new Exception("impossible to define");
        }
        try {
            firstInt = numeralTranslator.translateToInt(InputLines[0]);
            isOperation(InputLines[1]);
            secondInt = numeralTranslator.translateToInt(InputLines[2]);
        } catch (Exception e) {
            System.err.println("Произошло исключение: несоответствие входных данных необходимому шаблону\n" + e);
            System.exit(-1);
            return null;
        }
        operation = (char) InputLines[1].getBytes()[0];

        return new ArithmeticExpression(firstInt, secondInt, operation, isRoman);
    }

    private boolean isOperation(String str) throws Exception {
        if (str.getBytes().length != 1) {
            throw new Exception("Not operation");
        }
        switch ((char) str.getBytes()[0]) {
            case '/':
            case '*':
            case '+':
            case '-':
                return true;
            default:
                throw new Exception("Not operation");
        }
    }

    private boolean isRomanCheck(byte b) {
        switch ((char) b) {
            case 'I':
            case 'V':
            case 'X':
                return true;
            default:
                return false;
        }
    }

    private boolean isArabicCheck(byte b) {
        return ((char) b >= '0' && (char) b <= '9');
    }
}
