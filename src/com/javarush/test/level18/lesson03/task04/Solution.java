package com.javarush.test.level18.lesson03.task04;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        String filename;
        Scanner sc = new Scanner(System.in);
        filename = sc.nextLine();
        FileInputStream fs = new FileInputStream(filename);
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int min = 9999999;


        while (fs.available() > 0)
        {

            int tmp = fs.read();

            if (map.containsKey(tmp))
            {

                int val = map.get(tmp) + 1;
                map.put(tmp, val);

            } else
            {

                map.put(tmp, 1);
            }

        }

        for (Integer integer : map.values())
        {
            min = min > integer ? integer : min;
        }



        for (Integer integer : map.keySet())
        {
            if (map.get(integer) == min) System.out.print(integer + " ");
        }

        fs.close();
        sc.close();
    }
}
