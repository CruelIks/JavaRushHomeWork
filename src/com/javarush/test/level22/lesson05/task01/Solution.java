package com.javarush.test.level22.lesson05.task01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution {

    public static void main(String args[]) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();

        String result = null;

        try
        {
            result = getPartOfString(str);
            System.out.println(result);
        }
        catch(TooShortStringException e)
        {
            e.printStackTrace();
        }


        reader.close();
    }

    public static String getPartOfString(String string) throws TooShortStringException{

        String result = null;
        try
        {
            String[] array = string.split(" ");
            StringBuilder sb = new StringBuilder();

            for (int i = 1; i < 5; i++)
            {
                sb.append(array[i]).append(" ");
            }

            result = sb.toString();


        }
        catch (Exception e)
        {
            throw new TooShortStringException();
        }

        return result;
    }

    public static class TooShortStringException extends Exception{
    }
}
