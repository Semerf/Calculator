package main.interfaces.impl;

import main.interfaces.NumeralTranslator;

public class ArabicNumeralTranslator implements NumeralTranslator {
    @Override
    public int translateToInt(String str) throws Exception {
        return Integer.parseInt(str);
    }

    @Override
    public String translateToString(int i) throws Exception {
        return Integer.toString(i);
    }
}
