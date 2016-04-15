package com.javarush.test.level15.lesson12.home01;


import java.io.IOException;
import java.util.Scanner;

/* Разные методы для разных типов
1. Считать с консоли данные, пока не введено слово "exit".
2. Для каждого значения, кроме "exit", вызвать метод print. Если значение:
2.1. содержит точку '.', то вызвать метод print для Double;
2.2. больше нуля, но меньше 128, то вызвать метод print для short;
2.3. больше либо равно 128, то вызвать метод print для Integer;
2.4. иначе, вызвать метод print для String.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String line;
        while (!((line = sc.nextLine()).contains("exit")))
        {
            if (line.indexOf('.') > -1)
            {
                print(Double.parseDouble(line));
                continue;
            }

            try
            {
                int num = Integer.parseInt(line);

                if (num > 0 && num < 128)
                {
                    print((short) num);
                    continue;
                }
                else if (num >= 128) print(num);
            }
            catch (NumberFormatException e)
            {
                print(line);
                continue;
            }

        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
