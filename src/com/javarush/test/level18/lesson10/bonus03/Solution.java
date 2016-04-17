package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{

    private static String fileName;

    public static void main(String[] args)
    {

        String param = args[0];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try
        {
            fileName = reader.readLine();
            reader.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


        if (param.equals("-u")) update(args);
        else if (param.equals("-d")) delete(args);

    }

    private static void delete(String[] args)
    {
        ArrayList<String> list = new ArrayList<String>();
        try
        {
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            String line = null;

            while ((line = in.readLine()) != null)
            {
                if (line.substring(0, 8).trim().equals(args[1]))
                {
                } else
                {
                    list.add(line);
                }
            }
            in.close();


            FileWriter out = new FileWriter(fileName);
            for (String s : list)
            {
                out.write(s + "\n");
                System.out.println(s);
            }
            out.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void update(String[] args)
    {
        ArrayList<String> list = new ArrayList<String>();
        try
        {
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            String line = null;

            while ((line = in.readLine()) != null)
            {
                if (line.substring(0, 8).trim().equals(args[1]))
                {
                    String prodName = String.format("%-30s", args[2]).substring(0, 30);
                    String price = String.format("%-8s", args[3]).substring(0, 8);
                    String quantity = String.format("%-4s", args[4]).substring(0, 4);
                    line = String.format("%-8s", args[1]).substring(0, 8) + prodName + price + quantity;
                }
                list.add(line);
            }
            in.close();


            FileWriter out = new FileWriter(fileName);
            for (String s : list)
            {
                out.write(s + "\n");
                System.out.println(s);
            }
            out.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
