package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1;
        String text = " ";

        try
        {
            file1 = reader.readLine();
            reader.close();

            BufferedReader in = new BufferedReader(new FileReader(file1));

            while (in.ready())
            {
                text += in.readLine().toLowerCase() + ".";
            }

            in.close();
        }

        catch(IOException e) {e.printStackTrace();}

        /*System.out.println(text);*/
        text += " ";
        /*Pattern pattern = Pattern.compile("\\sworld(\\s|,|.|!|\\?)");*/
        Pattern pattern = Pattern.compile("(\\s|\\p{Punct})world(\\s|\\p{Punct})");
        Matcher matcher = pattern.matcher(text);

        int count = 0;
        int start = 0;

        while (true)
        {

            if (!matcher.find(start)) break;

            count++;
            /*System.out.println(start);*/
            start = matcher.start() + 1;


        }
        System.out.println(count);
    }
}
