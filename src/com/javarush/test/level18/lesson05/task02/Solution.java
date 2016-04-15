package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки. Не использовать try-with-resources

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        String filename;
        Scanner sc = new Scanner(System.in);
        filename = sc.nextLine();
        int result = 0;

        try
        {
            FileInputStream fs = new FileInputStream(filename);

            while (fs.available() > 0) {
                if (fs.read() == 44) result++;
            }
            fs.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


        System.out.println(result);
        sc.close();

    }
}
