package com.javarush.test.level12.lesson04.task01;

/* print(int) и print(String)
Написать два метода: print(int) и print(String).
*/

public class Solution
{
    public static void main(String[] args)
    {

       print(35);
       print(35.0);


    }

    static <T extends Number> void print(T i)
    {
        System.out.println(i);
    }


}
