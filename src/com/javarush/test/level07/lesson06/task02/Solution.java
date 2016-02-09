package com.javarush.test.level07.lesson06.task02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/* Самая длинная строка
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую длинную строку в списке.
4. Выведи найденную строку на экран.
5. Если таких строк несколько, выведи каждую с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<String> myA = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 5; i++)
        {
           myA.add(sc.nextLine());
        }

        int maxSize = 0;

        for (String i : myA)
        {
            maxSize = maxSize < i.length() ? i.length() : maxSize;
        }
        for (String i : myA)
        {
            if (i.length() == maxSize)
            {
                System.out.println(i);
            }
        }

    }
}
