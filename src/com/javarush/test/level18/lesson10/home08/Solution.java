package com.javarush.test.level18.lesson10.home08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution
{
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args)
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();

        try
        {

            String line = null;
            while (!"exit".equals(line = reader.readLine()))
            {

                list.add(line);
            }
            reader.close();
            for (String s : list)
            {
                ReadThread readThread = new ReadThread(s);
                readThread.start();
                readThread.join();
            }
        }
        catch (Exception e)
        {
        }


        for (Map.Entry<String, Integer> entry : resultMap.entrySet())
        {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    public synchronized static void setMapValue(String a, Integer b)
    {
        resultMap.put(a, b);
    }

    public static class ReadThread extends Thread
    {

        private String filename;

        public ReadThread(String fileName)
        {
            this.filename = fileName;
        }

        @Override
        public void run()
        {

            try
            {
                int maxByte = 0;
                FileInputStream fs = new FileInputStream(filename);
                HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

                while (fs.available() > 0)
                {

                    int a = fs.read();

                    if (map.containsKey(a))
                    {
                        int val = map.get(a) + 1;
                        map.put(a, val);
                        maxByte = maxByte > val ? maxByte : val;
                    } else
                    {
                        map.put(a, 1);
                        maxByte = maxByte > 1 ? maxByte : 1;
                    }

                }

                for (Map.Entry<Integer, Integer> entry : map.entrySet())
                {
                    if (entry.getValue() == maxByte)
                    {
                        /*resultMap.put(filename, entry.getKey());*/
                        setMapValue(filename, entry.getKey());
                    }
                }

                fs.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }


        }
    }
}
