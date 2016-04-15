package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {

        String fileName = args[0];
        String fileName2 = args[1];

        try
        {
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            FileWriter out = new FileWriter(fileName2);

            while (in.ready())
            {
                String line = in.readLine();
                String[] array = line.split(" ");

                for (String s : array)
                {
                    Pattern pattern = Pattern.compile("[0-9]");
                    Matcher matcher = pattern.matcher(s);
                    if(matcher.find())
                    {
                        out.write(s + " ");
                    }
                }
             }
            in.close();
            out.close();
        }
        catch(IOException e) {e.printStackTrace();}

    }
}
