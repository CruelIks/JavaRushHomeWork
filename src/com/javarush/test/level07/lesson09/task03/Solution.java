package com.javarush.test.level07.lesson09.task03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* Слово «именно»
1. Создай список из слов «мама», «мыла», «раму».
2. После каждого слова вставь в список строку, содержащую слово «именно».
3. Используя цикл for вывести результат на экран, каждый элемент списка с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        List<String> myList = new ArrayList<String>();
        myList.add("мама");
        myList.add("мыла");
        myList.add("раму");

        myList.add(1, " именно ");
        myList.add(3, " именно ");
        myList.add(5, " именно ");

        for (String i : myList) System.out.println(i);
    }
}
