package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
строка0                           ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка5                           ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
*/

public class Solution
{
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args)
    {

        String file1, file2;
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try
        {
            file1 = reader.readLine();
            file2 = reader.readLine();
            reader.close();

            BufferedReader in1 = new BufferedReader(new FileReader(file1));

            while (in1.ready())
            {
                list1.add(in1.readLine().trim());
            }
            in1.close();

            BufferedReader in2 = new BufferedReader(new FileReader(file2));

            while (in2.ready())
            {
                list2.add(in2.readLine().trim());
            }
            in2.close();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        int i = 0;
        int j = 0;

        while (true)
        {

            if ((i < list1.size()) && (j < list2.size()))
            {

                if (list1.get(i).equals(list2.get(j)))
                {
                    //same
                    lines.add(new LineItem(Type.SAME, list1.get(i)));
                    i++;
                    j++;
                } else if (i + 1 >= list1.size())
                {
                    //added
                    lines.add(new LineItem(Type.ADDED, list2.get(j)));
                    j++;
                } else if (list1.get(i + 1).equals(list2.get(j)))
                {
                    //removed
                    lines.add(new LineItem(Type.REMOVED, list1.get(i)));
                    i++;
                } else
                {
                    //added
                    lines.add(new LineItem(Type.ADDED, list2.get(j)));
                    j++;
                }

            } else if (i < list1.size())
            {
                //removed
                lines.add(new LineItem(Type.REMOVED, list1.get(i)));
                i++;
            } else if (j < list2.size())
            {
                //added
                lines.add(new LineItem(Type.ADDED, list2.get(j)));
                j++;
            } else
            {
                break;
            }


        }

        for (LineItem l : lines)
        {
            System.out.println(l.type.toString() + " " + l.line);
        }


    }


    public static enum Type
    {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem
    {
        public Type type;
        public String line;

        public LineItem(Type type, String line)
        {
            this.type = type;
            this.line = line;
        }
    }
}
