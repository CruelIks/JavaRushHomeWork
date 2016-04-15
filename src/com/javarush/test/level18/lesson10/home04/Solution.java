package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        String fileName1, fileName2;

        fileName1 = scanner.nextLine();
        fileName2 = scanner.nextLine();

        FileInputStream inFirst = new FileInputStream(fileName1);
        FileInputStream in = new FileInputStream(fileName2);


        byte[] b = new byte[in.available()];
        in.read(b);
        byte[] c = new byte[inFirst.available()];
        inFirst.read(c);

        inFirst.close();
        in.close();

        FileOutputStream out = new FileOutputStream(fileName1);
        out.write(b);
        out.write(c);
        out.close();
        scanner.close();


    }
}
