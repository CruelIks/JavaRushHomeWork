package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки. Не использовать try-with-resources

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int

Информация по каждому товару хранится в отдельной строке
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        String id = args[0];
        String filename;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        filename = reader.readLine();
        reader.close();

        BufferedReader in = new BufferedReader(new FileReader(filename));

        while(in.ready()) {
            String line = in.readLine();
            if (line.length() == 0) continue;

            String[] array = line.split(" ");
            if (array[0].equals(id)) System.out.println(line);

        }

        in.close();
    }
}
