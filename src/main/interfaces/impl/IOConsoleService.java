package main.interfaces.impl;

import main.interfaces.IOTool;

import java.util.Scanner;

public class IOConsoleService implements IOTool {

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
