package com.javarush.test.level07.lesson06.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/* Удали последнюю строку и вставь её в начало
1. Создай список строк.
2. Добавь в него 5 строчек с клавиатуры.
3. Удали последнюю строку и вставь её в начало. Повторить 13 раз.
4. Используя цикл выведи содержимое на экран, каждое значение с новой строки.
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

        for (int i = 0; i < 13 ; i++)
        {
            String tmp = myA.get(myA.size() - 1);
            myA.remove(myA.size() - 1);
            myA.add(0, tmp);
        }

        for (String i : myA) System.out.println(i);
    }
}
