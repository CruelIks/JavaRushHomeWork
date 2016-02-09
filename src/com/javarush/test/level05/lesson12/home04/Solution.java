package com.javarush.test.level05.lesson12.home04;

/* Вывести на экран сегодняшнюю дату
Вывести на экран текущую дату в аналогичном виде "21 02 2014".
*/

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Solution
{
    public static void main(String[] args)
    {

        String result;
        Date today = new Date();
        SimpleDateFormat df = new SimpleDateFormat("dd MM yyyy");

        result = df.format(today);
        System.out.println(result);
    }
}
