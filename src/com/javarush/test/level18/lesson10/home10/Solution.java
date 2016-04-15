package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution
{
    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<Integer, String> map = new TreeMap<Integer, String>();

        String fileName = null, resultFileName = "";

        while (!"end".equals(fileName = reader.readLine()))
        {
            int index = fileName.lastIndexOf(".part");
            int partNumber = Integer.parseInt(fileName.substring(index + 5));

            resultFileName = fileName.substring(0, index);
            map.put(partNumber, fileName);

        }

        FileOutputStream out = new FileOutputStream(resultFileName);
        /*BufferedOutputStream outBuff = new BufferedOutputStream(out);*/

        for (Map.Entry<Integer, String> entry : map.entrySet())
        {
            /*System.out.println(entry.getKey() + " " + entry.getValue());*/

            FileInputStream in = new FileInputStream(entry.getValue());

            byte[] b = new byte[in.available()];
            in.read(b);
            out.write(b);
            in.close();

        }

        reader.close();
        /*outBuff.close();*/
        out.close();

    }
}
