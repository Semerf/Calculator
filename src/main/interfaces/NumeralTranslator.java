package main.interfaces;

public interface NumeralTranslator {
    int translateToInt(String str) throws Exception;

    String translateToString(int i) throws Exception;
}
