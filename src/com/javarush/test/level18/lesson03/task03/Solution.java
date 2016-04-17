package com.javarush.test.level18.lesson03.task03;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String filename;
        int max = 0;

        Scanner sc = new Scanner(System.in);
        filename = sc.nextLine();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        FileInputStream file = new FileInputStream(filename);

        while (file.available() > 0) {

            int tmp = file.read();
            if (map.containsKey(tmp))
            {
                int val = map.get(tmp) + 1;
                map.put(tmp, val);
                max = max > val ? max : val;
            }
            else
            {
                map.put(tmp, 1);
                max = max > 1 ? max : 1;
            }

        }

        for (Integer integer : map.keySet())
        {
            if (map.get(integer) == max) System.out.print(integer + " ");
        }

        sc.close();
        file.close();
    }
}
