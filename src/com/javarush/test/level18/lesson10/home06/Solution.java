package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.TreeMap;


public class Solution {
    public static void main(String[] args) throws IOException
    {
        String fileName = args[0];

        TreeMap<Byte, Integer> map = new TreeMap<Byte, Integer>();

        FileInputStream in = new FileInputStream(fileName);

        byte[] b = new byte[in.available()];
        in.read(b);

        for (byte a : b)
        {
            if (map.containsKey(a))
            {
                map.put(a, map.get(a) + 1);
            } else
            {
                map.put(a, 1);

            }
        }

        for (byte a : map.keySet())
        {
            System.out.println((char) a + " " + map.get(a));
        }

        in.close();
    }
}
