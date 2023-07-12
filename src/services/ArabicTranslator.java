package services;

import interfaces.Translator;

public class ArabicTranslator implements Translator  {
    @Override
    public int translateToInt(String str) throws Exception {
        return Integer.parseInt(str);
    }

    @Override
    public String translateToString(int i)  throws Exception{
        return Integer.toString(i);
    }
}
