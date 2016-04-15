package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String file1, file2;
        file1 = sc.nextLine();
        file2 = sc.nextLine();

        try
        {
            FileInputStream fs = new FileInputStream(file1);
            FileOutputStream out = new FileOutputStream(file2);

            int count = fs.available();
            byte[] b = new byte[count];
            byte[] c = new byte[count];

            fs.read(b);

            for (int i = 0; i < b.length; i++)
            {
                c[i] = b[count - 1 - i];
            }

            out.write(c);

            fs.close();
            out.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        sc.close();
    }
}
