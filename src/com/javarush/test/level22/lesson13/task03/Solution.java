package com.javarush.test.level22.lesson13.task03;

import java.util.Scanner;

/* Проверка номера телефона
Метод checkTelNumber должен проверять, является ли аргумент telNumber валидным номером телефона.
Критерии валидности:
1) если номер начинается с '+', то он содержит 12 цифр
2) если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр
3) может содержать 0-2 знаков '-', которые не могут идти подряд
4) может содержать 1 пару скобок '(' и ')'  , причем если она есть, то она расположена левее знаков '-'
5) скобки внутри содержат четко 3 цифры
6) номер не содержит букв
7) номер заканчивается на цифру

Примеры:
+380501234567 - true
+38(050)1234567 - true
+38050123-45-67 - true
050123-4567 - true

+38)050(1234567 - false
+38(050)1-23-45-6-7 - false
050ххх4567 - false
050123456 - false
(0)501234567 - false
*/
public class Solution
{

    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        scanner.close();

        System.out.println(checkTelNumber(number));
    }

    public static boolean checkTelNumber(String telNumber)
    {

        boolean result = true;
        if (telNumber == null) return false;
        if (telNumber.length() == 0) return false;

        if (telNumber.charAt(0) == '+' && !telNumber.matches("\\+(\\D*\\d\\D*){12}"))
        {
            return false;
        }
        if (telNumber.matches("^\\(.*") && !telNumber.matches("(\\D*\\d\\D*){10}"))
        {
            return false;
        }
        if (telNumber.matches("^\\d.*") && !telNumber.matches("^\\d(\\D*\\d\\D*){9}"))
        {
            return false;
        }

        if (telNumber.matches("(.*-.*){3,}")) return false;


        if (telNumber.matches(".*--.*")) return false;

        if (telNumber.matches(".*\\).*\\(.*")) return false;
        if (telNumber.matches("(.*\\(.*){2,}|(.*\\).*){2,}")) return false;


        if (telNumber.matches(".*\\(.*|.*\\).*"))
        {
            if (!telNumber.matches(".*\\(\\d{3}\\).*")) return false;

            if (telNumber.contains("-") && telNumber.matches(".*-.*\\(.*")) return false;
        }
        if (telNumber.matches(".*[A-z].*")) return false;
        if (telNumber.matches(".*[А-я].*")) return false;
        if (telNumber.matches(".*\\D$")) return false;

        return result;
    }
}