package main.service.impl;

import main.service.NumeralTranslatorService;

import java.util.HashMap;
import java.util.Map;

public class RomanNumeralTranslatorServiceImpl implements NumeralTranslatorService {
    @Override
    public int translateToInt(String str) throws Exception {
        byte[] symbols = str.getBytes();
        int result = 0;
        int max = -1;

        Map<Character, Integer> dict = new HashMap<>();
        dict.put('I', 1);
        dict.put('V', 5);
        dict.put('X', 10);
        for (byte symbol : symbols) {
            if (dict.get((char) symbol) == null) {
                throw new Exception("Found no Roman number");
            }
        }
        for (int i = symbols.length - 1; i >= 0; i--) {
            if (dict.get((char) symbols[i]) >= max) {
                result += dict.get((char) symbols[i]);
                max = dict.get((char) symbols[i]);

            } else {
                result -= dict.get((char) symbols[i]);
            }
        }
        if (result <= 0) {
            throw new Exception("Сonversion error");
        }
        return result;
    }

    @Override
    public String translateToString(int input) throws Exception {
        StringBuilder str = new StringBuilder();
        if (input / 10 == 1) {
            str.append('X');
            input -= 10;
        } else if (input / 10 == 2) {
            str.append("XX");
            input -= 20;
        } else if (input / 10 > 2) {
            throw new Exception("too large a number");
        }
        switch (input) {
            case 1:
                str.append("I");
                break;
            case 2:
                str.append("II");
                break;
            case 3:
                str.append("III");
                break;
            case 4:
                str.append("IV");
                break;
            case 5:
                str.append("V");
                break;
            case 6:
                str.append("VI");
                break;
            case 7:
                str.append("VII");
                break;
            case 8:
                str.append("IIX");
                break;
            case 9:
                str.append("IX");
                break;
        }
        return str.toString();
    }
}
