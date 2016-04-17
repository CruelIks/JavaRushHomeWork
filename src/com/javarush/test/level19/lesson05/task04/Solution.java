package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args)
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file1, file2;

        try
        {
            file1 = reader.readLine();
            file2 = reader.readLine();
            reader.close();

            BufferedReader in = new BufferedReader(new FileReader(file1));
            FileWriter out = new FileWriter(file2);

            while (in.ready())
            {
               char symbol = (char)in.read();
               symbol = symbol == '.' ? '!' : symbol;
               out.write(symbol);
            }
            in.close();
            out.close();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
