package main.interfaces;

public interface NumeralTranslatorService {
    int translateToInt(String str) throws Exception;

    String translateToString(int i) throws Exception;
}
