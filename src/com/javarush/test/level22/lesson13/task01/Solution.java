package com.javarush.test.level22.lesson13.task01;

import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {
    public static String [] getTokens(String query, String delimiter) {

        StringTokenizer st = new StringTokenizer(query, delimiter);
        int count = st.countTokens();
        String[] array = new String[count];

        for (int i = 0; i < count ; i++)
        {
            array[i] = st.nextToken();
        }

        return array;
    }

    public static void main(String args[]){

        String[] my = getTokens("level22.lesson13.task01", ".");

        for (String s: my)
        {
            System.out.println(s);
        }
    }
}
