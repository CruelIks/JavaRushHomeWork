package com.javarush.test.level07.lesson06.task01;

import java.util.ArrayList;
import java.util.Scanner;

/* 5 различных строчек в списке
1. Создай список строк.
2. Добавь в него 5 различных строчек.
3. Выведи его размер на экран.
4. Используя цикл выведи его содержимое на экран, каждое значение с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<String> myA = new ArrayList<String>();
        myA.add("Fuck");
        myA.add("You");
        myA.add("Stupid");
        myA.add("User");
        myA.add("!");

        System.out.println(myA.size());

        for (int i = 0; i < myA.size() ; i++)
        {
            System.out.println(myA.get(i));
        }

    }
}
