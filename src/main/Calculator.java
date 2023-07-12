package main;

import interfaces.Splitter;
import interfaces.IOutil;
import interfaces.Translator;
import services.ArabicTranslator;
import services.IOService;
import services.RomanTranslator;
import services.SplitService;

public class Calculator {
    public static void main(String[] args) {
        IOutil ioutil = new IOService();
        Splitter splitter = new SplitService();
        Translator translator;
        ArithmeticExpression expression;
        try {
            expression = splitter.SplitInputString(ioutil.read());
            int result = calculate(expression);
            if (expression.isRoman()) {
                translator = new RomanTranslator();
            } else {
                translator = new ArabicTranslator();
            }
            ioutil.write(translator.translateToString(result));
        } catch (Exception e){
            System.out.println(e);
            System.exit(-1);
        }
    }
    public static int calculate(ArithmeticExpression expression) throws Exception{
        int result = 0;
        switch (expression.getOperation()){
            case '+':
                result = expression.getFirstInt() + expression.getSecondInt();
                break;
            case  '-':
                result = expression.getFirstInt()-expression.getSecondInt();
                break;
            case '/':
                result = expression.getFirstInt()/expression.getSecondInt();
                break;
            case '*':
                result = expression.getFirstInt()*expression.getSecondInt();
                break;
        }
        if(result < 1 && expression.isRoman()) {
            throw new Exception("Roman numerals cannot be less than 1");
        }

        return result;
    }
}
