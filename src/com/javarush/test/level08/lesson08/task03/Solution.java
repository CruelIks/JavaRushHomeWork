package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Иванов", "Кирилл");
        map.put("Каширин", "Костя");
        map.put("Иванова", "Мария");
        map.put("Крюков", "Максим");
        map.put("Сергеева", "Елена");
        map.put("Сауткина", "Наталья");
        map.put("Сауткин", "Сергей");
        map.put("Николаев", "Степан");
        map.put("Денисов", "Борис");
        map.put("Петров", "Сергей");

        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        int col = 0;
        for (String s : map.keySet())
        {
            if (map.get(s).equals(name)) col ++;
        }

        return col;

    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName)
    {
        int col = 0;

        for (String s : map.keySet())
        {
            if (s.equals(lastName)) col++;
        }
        return col;

    }
}
