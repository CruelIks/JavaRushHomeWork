package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        char ch[] = s.toCharArray();

        for (int i = 0; i < (ch.length - 1) ; i++)
        {
            if (ch[i] == ' ' & ch[i + 1] != ' ')

                ch[i + 1] = Character.toUpperCase(ch[i+1]);

        }

        if (ch[0] != ' ') ch[0] = Character.toUpperCase(ch[0]);

        String result = new String(ch);
        System.out.println(result);

    }


}
