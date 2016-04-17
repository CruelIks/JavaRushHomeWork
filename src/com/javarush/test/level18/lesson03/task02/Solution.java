package com.javarush.test.level18.lesson03.task02;

import java.io.FileInputStream;
import java.util.Scanner;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        String filename;
        int max = 99999;
        Scanner sc = new Scanner(System.in);
        filename = sc.nextLine();

        FileInputStream file = new FileInputStream(filename);

        while (file.available() > 0) {

            int tmp = file.read();
            max = max < tmp ? max : tmp;

        }
        System.out.println(max);
        sc.close();
        file.close();

    }
}
