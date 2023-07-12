package main.services.impl;

import main.services.IOToolService;

import java.util.Scanner;

public class IOConsoleServiceImpl implements IOToolService {

    @Override
    public String[] readAndSplit() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите ваше выражение");
        String inputStr = sc.nextLine();
        sc.close();
        String[] elements = inputStr.split(" ");
        if (elements.length != 3) {
            throw new Exception();
        }
        System.out.println(inputStr);
        return elements;
    }

    @Override
    public void write(String str) {
        System.out.println(str);
    }
}
