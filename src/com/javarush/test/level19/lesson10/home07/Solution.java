package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Solution {
    public static void main(String[] args) {
        String fileName1 = args[0], fileName2 = args[1];
        String result = "";

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(fileName1));
            FileWriter out = new FileWriter(fileName2);

            while (reader.ready())
            {
                String[] array = reader.readLine().split(" ");

                for (String s : array)
                {
                    if (s.length() > 6) result += s + ",";
                }
            }

            if (result.length() > 0)
            {
                result = result.substring(0, result.lastIndexOf(","));
            }

            out.write(result);

            reader.close();
            out.close();

        }
        catch (IOException e) {e.printStackTrace();}

    }
}
