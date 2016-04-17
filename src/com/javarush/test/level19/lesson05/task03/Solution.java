package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file1, file2;

        try
        {
            file1 = reader.readLine();
            file2 = reader.readLine();
            reader.close();

            String text = "";

            BufferedReader in = new BufferedReader(new FileReader(file1));

            while (in.ready())
            {
                text += in.readLine() + " ";
            }
            in.close();

            FileWriter out = new FileWriter(file2);

            String[] array = text.split(" ");

            for (String s : array)
            {
                try
                {
                    int i = Integer.parseInt(s.trim());
                    /*System.out.println(i);*/
                    out.write("" + i + " ");
                }
                catch (NumberFormatException e) {continue;}


            }
            out.close();

        }
        catch(IOException e) {e.printStackTrace();}
    }
}
