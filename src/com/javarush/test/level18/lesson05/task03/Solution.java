package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        String f1, f2, f3;
        Scanner sc = new Scanner(System.in);

        f1 = sc.nextLine();
        f2 = sc.nextLine();
        f3 = sc.nextLine();

        try
        {
            FileInputStream fs = new FileInputStream(f1);
            FileOutputStream fs2 = new FileOutputStream(f2);
            FileOutputStream fs3 = new FileOutputStream(f3);

            int colBayt = fs.available();
            int end;

            if (colBayt % 2 == 1) {
                end = colBayt / 2 + 1;
            }
            else {
                end = colBayt / 2;
            }

            byte b[] = new byte[colBayt];
            int count = fs.read(b);
            fs2.write(b, 0, end);
            fs3.write(b, end, (colBayt - end));

            fs.close();
            fs2.close();
            fs3.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        sc.close();
    }
}
