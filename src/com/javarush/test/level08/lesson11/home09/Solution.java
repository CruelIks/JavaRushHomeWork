package com.javarush.test.level08.lesson11.home09;


import java.util.Date;
import java.util.Scanner;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String tmp = sc.nextLine();
        isDateOdd(tmp);

    }

    public static boolean isDateOdd(String date)
    {

        Date d1 = new Date(date);
        Date d2 = new Date("JANUARY 1 " + (d1.getYear() + 1900));

        long kolDnei = (d1.getTime() - d2.getTime()) / (24 * 60 * 60 * 1000) + 1;

        if (kolDnei % 2 == 0)
            return false;
        else
            return true;

    }
}
