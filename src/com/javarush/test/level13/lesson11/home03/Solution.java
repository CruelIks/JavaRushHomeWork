package com.javarush.test.level13.lesson11.home03;

/* Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть освободить ресурсы. Закрыть поток чтения с файла и поток ввода с клавиатуры.
*/

import java.io.*;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();

        FileReader fs = new FileReader(fileName);

        while (true)
        {

            int i = fs.read();
            if (i == -1 ) break;
            System.out.print((char) i);
        }

        sc.close();
        fs.close();
    }
}
