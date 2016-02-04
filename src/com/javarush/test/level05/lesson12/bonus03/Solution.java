package com.javarush.test.level05.lesson12.bonus03;

import java.io.*;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maximum;
        int N = Integer.parseInt(reader.readLine());
        int[] myArray = new int[N];

        for (int i = 0; i < N; i++)
        {
            myArray[i] = Integer.parseInt(reader.readLine());
        }

        maximum = getMax(myArray);


        System.out.println(maximum);
    }

    private static int getMax(int[] myArray)
    {
        int result;

        for (int i = 0; i < myArray.length; i++)
        {
            for (int j = i + 1; j < myArray.length; j++)
            {
                if (myArray[i] > myArray[j]) {
                    int tmp = myArray[i];
                    myArray[i] = myArray[j];
                    myArray[j] = tmp;
                }
            }
        }
        result = myArray[myArray.length - 1];

        return result;
    }
}
