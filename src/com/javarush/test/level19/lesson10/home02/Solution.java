package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {

        String fileName = args[0];
        TreeMap<String, Double> map = new TreeMap<String, Double>();
        double maxSum = 0;

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
                    double tmp = map.get(name) + sum;
                    map.put(name, tmp);
                    maxSum = maxSum > tmp ? maxSum : tmp;
                }
                else
                {
                    map.put(name, sum);
                    maxSum = maxSum > sum ? maxSum : sum;
                }
            }

            reader.close();
            buffer.close();
        }
        catch(IOException e) {e.printStackTrace();}

        for (String s : map.keySet())
        {
            if (map.get(s) != maxSum) continue;
            System.out.println(s);
        }
    }
}
