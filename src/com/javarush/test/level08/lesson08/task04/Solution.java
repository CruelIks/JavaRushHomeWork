package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("Stallon", new Date("JUNE 1 1980"));
        map.put("Stallo", new Date("JUNE 1 1980"));
        map.put("Stall", new Date("JUNE 1 1980"));
        map.put("Stal", new Date("JUNE 1 1980"));

        map.put("tallone", new Date("JUNE 1 1980"));
        map.put("allone", new Date("JUNE 1 1980"));
        map.put("llone", new Date("JUNE 1 1980"));
        map.put("one", new Date("JUNE 1 1980"));
        map.put("tallon", new Date("JUNE 1 1980"));

        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        Iterator<Map.Entry<String,Date>> iterator = map.entrySet().iterator();

        while (iterator.hasNext())
        {
            Map.Entry<String,Date> pair = iterator.next();
            if (pair.getValue().getMonth()==5 || pair.getValue().getMonth()==6 || pair.getValue().getMonth()==7){
                iterator.remove();

            }

        }



    }

    public static void main(String args[])
    {
        HashMap myMap = createMap();
        removeAllSummerPeople(myMap);
    }
}
