package com.javarush.test.level12.lesson04.task05;

/* Три метода возвращают максимальное из двух переданных в него чисел
Написать public static методы: int max(int, int), long max (long, long), double max (double, double).
Каждый метод должен возвращать максимальное из двух переданных в него чисел.
*/

public class Solution
{
    public static void main(String[] args)
    {

        System.out.println(max(3,4));
        System.out.println(max(3.5, 4.0));


    }

    public static <T extends Number> T max(T x, T y)
    {

        return x.doubleValue() > y.doubleValue() ? x : y;
    }


}
