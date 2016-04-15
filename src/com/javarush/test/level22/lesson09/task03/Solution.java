package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution
{
    public static void main(String[] args)
    {

        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName;
            fileName = reader.readLine();
            reader.close();

            BufferedReader in = new BufferedReader(new FileReader(fileName));
            ArrayList<String> list = new ArrayList<>();

            while (in.ready())
            {
                String[] array = in.readLine().split(" ");
                Collections.addAll(list, array);

            }
            in.close();

            String[] words = new String[list.size()];
            words = list.toArray(words);

            StringBuilder result = getLine(words);
            System.out.println(result.toString());
        }
        catch (Exception e) {e.printStackTrace();}
    }

    public static StringBuilder getLine(String... words)
    {

        if (words == null || words.length == 0)
            return new StringBuilder();
        if (words[0].equals(""))
            return new StringBuilder(words[0]);

        List<String> list = Arrays.asList(words);
        StringBuilder result = new StringBuilder();

        for (String s : words)
        {
            if (s.length() == 0) continue;
            result.append(s).append(" ");
        }

        ArrayList<Integer> blackList = new ArrayList<Integer>();

        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i).length() == 0) continue;
            blackList.clear();
            blackList.add(i);
           /* StringBuilder sorted = new StringBuilder();
            sorted.append(list.get(i)).append(" "); */

            //commentary
            ArrayList<String> sorted = new ArrayList<>();
            List<String> unSorted = list.subList(0, list.size());

            char lastChar = Character.toLowerCase(list.get(i).charAt(list.get(i).length() - 1));

            sortAll(unSorted, blackList, lastChar, sorted);


            for (String s : sorted) System.out.print(s + "-");
            System.out.println("\n");

            /*if ((result.length()) == sorted.length())
            {
                result = sorted;
                break;
            }*/

        }

        return result;
    }

    private static void sortAll(List<String> unSorted, ArrayList<Integer> sortBlackList, char l, List<String> sorted)
    {

        /*for (int j = 0; j < sortList.size(); j++)
        {
            if (sortBlackList.indexOf(j) != -1) continue;
            if (sortList.get(j).length() == 0) continue;
            char f = Character.toLowerCase(sortList.get(j).charAt(0));
            if (f == l)
            {
                sortBlackList.add(j);
                sorted.add(sortList.get(j));
                char lastChar = Character.toLowerCase(sortList.get(j).charAt(sortList.get(j).length() - 1));
                sortAll(sortList, sortBlackList, lastChar, sorted);
                break;
            }
        }*/

        Iterator<String> iter = unSorted.iterator();
        while (iter.hasNext())
        {
            String s = iter.next();
            /*if (s.length() == 0) continue;*/

            char f = Character.toLowerCase(s.charAt(0));
            if (f == l)
            {
                sorted.add(s);
                iter.remove();
                char lastChar = Character.toLowerCase(s.charAt(s.length() - 1));
                sortAll(unSorted, sortBlackList, lastChar, sorted);
                break;
            }
        }

        if ((unSorted.size() > 0) && (sorted.size() > 1))

        {

            String badGuy = sorted.get(sorted.size() - 1);
            char lastChar = Character.toLowerCase(badGuy.charAt(0));
            unSorted.add(badGuy);
            sorted.remove(sorted.size() - 1);

            sortAll(unSorted, sortBlackList, lastChar, sorted);

        }

    }


}

