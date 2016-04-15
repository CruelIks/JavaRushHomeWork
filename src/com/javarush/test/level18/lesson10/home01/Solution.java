package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {

        int result = 0;
        String fileName = args[0];

        try
        {
            FileInputStream in = new FileInputStream(fileName);
            byte[] b = new byte[in.available()];
            in.read(b);

            for (byte s : b) {

                if (((s >= 97) && (s <= 122)) || ((s >= 65) && (s <= 90))) {
                   result++;
                }

            }

            System.out.println(result);
            in.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


    }
}
