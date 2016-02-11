package com.javarush.test.level08.lesson08.task05;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
       HashMap<String, String> map = new HashMap<String, String>();
        map.put("qw", "qw");
        map.put("qq", "qw");
        map.put("ww", "qw");
        map.put("rr", "rqw");
        map.put("qww", "weqw");
        map.put("qweqw", "eeeqw");
        map.put("qwqew", "qwweqw");
        map.put("qwffd", "qw");
        map.put("qwfdf", "qw");
        map.put("dfffdf", "qfffw");
        return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {

        HashMap<String, String> map2 = new HashMap<String, String>(map);
        HashMap<String, String> map3 = new HashMap<String, String>(map);

        for (String s : map2.keySet())
        {
            map3.remove(s);

            if (map3.containsValue(map2.get(s)))
            {
                removeItemFromMapByValue(map, map2.get(s));
            }


        }

    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);

        for (Map.Entry<String, String> pair: copy.entrySet())
        {
           if (pair.getValue().equals(value))

               map.remove(pair.getKey());

                        }

    }

    public static void main(String args[])
    {
        HashMap<String, String> myMap = createMap();

        System.out.println("SIZE: " + myMap.size());
        removeTheFirstNameDuplicates(myMap);
        System.out.println("SIZE: " + myMap.size());
        for (String s : myMap.keySet())
        {
            System.out.println(myMap.get(s));
        }

    }
}
