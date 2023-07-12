package main.interfaces.impl;

import main.interfaces.NumeralTranslatorService;

public class ArabicNumeralTranslatorServiceImpl implements NumeralTranslatorService {
    @Override
    public int translateToInt(String str){
        return Integer.parseInt(str);
    }

    @Override
    public String translateToString(int i){
        return Integer.toString(i);
    }
}
