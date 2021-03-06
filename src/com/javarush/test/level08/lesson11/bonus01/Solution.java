package com.javarush.test.level08.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.*;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
Используйте коллекции.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        Map<String, Integer> year = new HashMap<String, Integer>();
        year.put("January", 1);
        year.put("February", 2);
        year.put("March", 3);
        year.put("April", 4);
        year.put("May", 5);
        year.put("June", 6);
        year.put("July", 7);
        year.put("August", 8);
        year.put("September", 9);
        year.put("October", 10);
        year.put("November", 11);
        year.put("December", 12);

        Scanner sc = new Scanner(System.in);
        String month = sc.nextLine();

        System.out.println(month + " is "  + year.get(month) + " month");

    }

}
