package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        Scanner sc = new Scanner(System.in);
        String f1, f2, f3;
        f1 = sc.nextLine();
        f2 = sc.nextLine();
        f3 = sc.nextLine();

        FileInputStream in2 = new FileInputStream(f2);
        FileInputStream in3 = new FileInputStream(f3);

        byte[] b2 = new byte[in2.available()];
        byte[] b3 = new byte[in3.available()];
        in2.read(b2);
        in3.read(b3);

        FileOutputStream out = new FileOutputStream(f1, true);
        out.write(b2);
        out.write(b3);



        sc.close();
        in2.close();
        in3.close();
        out.close();
    }
}
