package com.javarush.test.level08.lesson08.task01;

import java.util.HashSet;
import java.util.Set;

/* 20 слов на букву «Л»
Создать множество строк (Set<String>), занести в него 20 слов на букву «Л».
*/

public class Solution
{
    public static HashSet<String> createSet()
    {
        HashSet<String> set = new HashSet<String>();
        set.add("Лошад");
        set.add("Лоша");
        set.add("Лош");
        set.add("Лоь");
        set.add("Лодь");
        set.add("Лшадь");
        set.add("Ладь");
        set.add("Лдь");
        set.add("Ль");
        set.add("Лошадьdsfg");
        set.add("Лошdfgdfgадь");
        set.add("Лоfghfghdfgdfgшадь");
        set.add("Лошdfgfghhdfgадь");
        set.add("Лошаdfhgfhgdдь");
        set.add("Лошаdfghь");
        set.add("Лошаdsfgdsfgдь");
        set.add("Лоddffшадь");
        set.add("Лоdfgdsfgшадь");
        set.add("Лошssdfgggадь");
        set.add("Лошаffgdsfgдь");
        return set;
    }
}
