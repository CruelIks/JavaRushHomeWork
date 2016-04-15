package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution
{
    public static Map<String, String> properties = new HashMap<>();
    public static Properties props = new Properties();

    public void fillInPropertiesMap()
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            String fileName = reader.readLine();
            reader.close();

            FileInputStream in = new FileInputStream(fileName);
            load(in);
            in.close();


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void save(OutputStream outputStream) throws Exception {
        PrintWriter printWriter = new PrintWriter(outputStream);
        if (props.size() > 0)
        props.putAll(properties);
        props.store(outputStream, "");
        printWriter.close();
    }

    public void load(InputStream inputStream) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        props.load(inputStream);
        Set<String> list = props.stringPropertyNames();
        for (String current : list)
            properties.put(current, props.getProperty(current));
        bufferedReader.close();
    }
}
