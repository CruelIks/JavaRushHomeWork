package com.javarush.test.level30.lesson02.task01;

/* Осваиваем методы класса Integer
Используя метод Integer.parseInt(String, int) реализуйте логику метода convertToDecimalSystem,
который должен переводить переданную строку в десятичное число и возвращать его в виде строки.
*/
public class Solution
{

    public static void main(String[] args)
    {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s)
    {

        int number = 0;


        try
        {
            if (s.substring(0, 2).equals("0b")){
                number = Integer.parseInt(s.replace("0b", ""), 2);
            }
            else if (s.substring(0, 2).equals("0x")){
                number = Integer.decode(s);
            }
            else if (s.substring(0, 1).equals("0")){
                number = Integer.parseInt(s, 8);
            }
            else
            {
                number = Integer.parseInt(s, 10);
            }
        }
        catch (NumberFormatException e)
        {
            System.out.println(s + " not a number may be " + Integer.decode(s));
        }


        return "" + number;
    }
}
