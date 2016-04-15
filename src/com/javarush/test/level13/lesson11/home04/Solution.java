package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();
        FileWriter fw = new FileWriter(fileName, false);

        String tmp = "";
        do
        {
            tmp = sc.nextLine();

            fw.write(tmp);
            fw.append('\r');
            fw.append('\n');



        } while (!tmp.equals("exit"));

        sc.close();

        fw.close();

    }
}
