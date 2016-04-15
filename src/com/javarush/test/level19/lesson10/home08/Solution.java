package com.javarush.test.level19.lesson10.home08;

/* Перевертыши
1 Считать с консоли имя файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке
2.2 вывести на экран
3 Закрыть потоки. Не использовать try-with-resources

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        String fileName;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try
        {
            fileName = reader.readLine();
            reader.close();

            BufferedReader in = new BufferedReader(new FileReader(fileName));

            while (in.ready())
            {
                String line = in.readLine();
                char[] array = line.toCharArray();

                for (int i = 0; i < ((array.length - 1) / 2) ; i++)
                {
                    char tmp = array[i];
                    array[i] = array[array.length - 1 - i];
                    array[array.length - 1 - i] = tmp;
                }

                String result = new String(array);
                System.out.println(result);

            }
            in.close();
        }
        catch(IOException e) {e.printStackTrace();}
    }
}
