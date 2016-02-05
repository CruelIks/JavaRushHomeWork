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
            for (int j = i + 1; j < 5 ; j++)
            {
                int tmp = ma[i];
                if (ma[i] > ma[j])
                {
                    int tmpVar = ma[i];
                    ma[i] = ma[j];
                    ma[j] = tmpVar;
                }
            }

        }

        for (int i = 0; i < 5 ; i++)
        {
            System.out.println(ma[i]);
        }

    }
}
