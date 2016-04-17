package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {

        String fileName = args[0];
        TreeMap<String, Double> map = new TreeMap<String, Double>();

        try
        {
            FileReader reader = new FileReader(fileName);
            BufferedReader buffer = new BufferedReader(reader);

            while (buffer.ready())
            {
                String[] array = buffer.readLine().split(" ");
                String name = array[0].trim();
                double sum = Double.parseDouble(array[1].trim());

                if (map.containsKey(name))
                {
                    map.put(name, map.get(name) + sum);
                }
                else
                {
                    map.put(name, sum);
                }
            }

            reader.close();
            buffer.close();
        }
        catch(IOException e) {e.printStackTrace();}

        for (String s : map.keySet())
        {
            System.out.println(s + " " + map.get(s));
        }

    }
}
