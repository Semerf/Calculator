package services;

import interfaces.Splitter;
import interfaces.Translator;
import main.ArithmeticExpression;

public class SplitService implements Splitter {
    @Override
    public ArithmeticExpression SplitInputString(String[] strs) throws Exception {
        boolean isRoman = false;
        int firstInt = 0;
        int secondInt = 0;
        char operation = '~';
        Translator translator;
        if(isRomanCheck(strs[0].getBytes()[0])) {
            isRoman = true;
            translator = new RomanTranslator();
        } else if (isArabicCheck(strs[0].getBytes()[0])) {
            translator = new ArabicTranslator();
        } else {
            throw new Exception("impossible to define");
        }
        try {
            firstInt = translator.translateToInt(strs[0]);
            isOperation(strs[1]);
            secondInt = translator.translateToInt(strs[2]);
        }catch (Exception e) {
            System.err.println("Произошло исключение: несоответствие входных данных необходимому шаблону\n" + e);
            System.exit(-1);
        }
        operation = (char) strs[1].getBytes()[0];

        return new ArithmeticExpression(firstInt, secondInt, operation, isRoman);
    }

    private boolean isOperation(String str) throws Exception{
        if(str.getBytes().length != 1){
            throw new Exception("Not operation");
        }
        switch ((char) str.getBytes()[0]){
            case '/':
                return true;
            case '*':
                return true;
            case '+':
                return true;
            case '-':
                return true;
            default:
                throw new Exception("Not operation");
        }
    }

    private boolean isRomanCheck(byte b){
        switch ((char) b){
            case 'I':
                return true;
            case 'V':
                return true;
            case 'X':
                return true;
            default:
                return false;
        }
    }
    private boolean isArabicCheck(byte b){
       return ((char) b >= '0' && (char) b <='9');
    }
}
