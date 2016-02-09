package com.javarush.test.level06.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
Пример ввода:
3
2
15
6
17
Пример вывода:
2
3
6
15
17
*/

public class Solution
{

    public static void printArray(int ma[])
    {
        for (int i : ma) System.out.print(i + " ");
    }

    public static void main(String[] args) throws Exception
    {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));

        int[] ma = new int[5];
        for (int i = 0; i < 5 ; i++)
        {
            ma[i] = Integer.parseInt(reader.readLine());
        }

        for (int i = 0; i < 5 ; i++)
        {
            for (int j = 0; j < (5 - i - 1); j++)
            {
                int tmp = ma[i];
                if (ma[j] > ma[j + 1])
                {
                    int tmpVar = ma[j];
                    ma[j] = ma[j + 1];
                    ma[j + 1] = tmpVar;
                }
            }

            printArray(ma);
            System.out.println("");

        }

        for (int i = 0; i < 5 ; i++)
        {
            System.out.println(ma[i]);
        }

    }
}
