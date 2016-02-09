package com.javarush.test.level07.lesson04.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* Один большой массив и два маленьких
1. Создать массив на 20 чисел.
2. Ввести в него значения с клавиатуры.
3. Создать два массива на 10 чисел каждый.
4. Скопировать большой массив в два маленьких: половину чисел в первый маленький, вторую половину во второй маленький.
5. Вывести второй маленький массив на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int[] bigArray = new int[20];
        int[] arr1 = new int[10];
        int[] arr2 = new int[10];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 20; i++)
        {
            bigArray[i] = Integer.parseInt(sc.nextLine());
        }
        for (int i = 0; i < 20 ; i++)
        {
            if (i < 10)
            {
                arr1[i] = bigArray[i];
            }
            else
            {
                arr2[i - 10] = bigArray[i];
            }
        }

        for (int i : arr2)
        {
            System.out.println(i);
        }

    }
}
