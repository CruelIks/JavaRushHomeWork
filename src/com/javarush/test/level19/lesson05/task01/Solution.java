package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
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

            FileInputStream in = new FileInputStream(file1);
            FileOutputStream out = new FileOutputStream(file2);

            int i = 0;
            while (in.available() > 0)
            {
                i++;
                int c = in.read();
                if (i % 2 == 0) out.write(c);
            }



            in.close();
            out.close();
        }
        catch (IOException e) {e.printStackTrace();}




    }
}
