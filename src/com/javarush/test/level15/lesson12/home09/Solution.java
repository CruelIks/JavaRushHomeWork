package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        String url;
        List<String> objValue = new ArrayList<String>();
        Scanner scaner = new Scanner(System.in);
        url = scaner.nextLine();

        String param = url.substring(url.indexOf('?') + 1);

        String params[] = param.split("&");


        for (String i : params)
        {
            String tmp[] = i.split("=");
            String nameParametr = tmp[0];
            System.out.print(nameParametr + " ");

            if (nameParametr.equals("obj"))
            {
                if (i.length() > 4)
                {
                    objValue.add(tmp[1]);
                } else
                {
                    objValue.add("");
                }
            }

        }

        System.out.println("");

        for (String s : objValue)
        {
            try
            {
                alert(Double.parseDouble(s));
            }
            catch (Exception e)
            {
                alert(s);
            }
        }
        scaner.close();

    }

    public static void alert(double value)
    {
        System.out.println("double " + value);
    }

    public static void alert(String value)
    {
        System.out.println("String " + value);
    }
}
