package com.javarush.test.level22.lesson05.task02;

/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException
    {

        if (string == null) throw new TooShortStringException();
        int first = -1;
        int last = -1;

        String result = null;
        first = string.indexOf("\t");
        last = string.indexOf("\t", first + 1);

        if ((first == last) | (first == -1) | (last == -1)) {
            throw new TooShortStringException();
        }

        result = string.substring((first + 1), last);

        return result;
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("tab0\ttab\ttab1\t"));       //tab
        System.out.println(getPartOfString("\t\t"));                    //
        System.out.println(getPartOfString("123\t123"));                //Exception
        System.out.println(getPartOfString(null));                      //Exception
    }
}
