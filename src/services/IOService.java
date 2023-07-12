package services;

import interfaces.IOutil;

import java.sql.SQLOutput;
import java.util.Scanner;

public class IOService implements IOutil {

    @Override
    public String[] read() throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите ваше выражение");
        String inputStr = sc.nextLine();
        sc.close();
        String[] els = inputStr.split(" ");
        if (els.length !=3){
            throw new Exception();
        }
        System.out.println(inputStr);
        return els;
    }

    @Override
    public void write(String str) {
        System.out.println(str);
    }
}
