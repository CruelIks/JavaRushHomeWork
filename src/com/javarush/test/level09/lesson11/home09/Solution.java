package com.javarush.test.level09.lesson11.home09;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap()
    {
        HashMap<String, Cat> map = new HashMap<String, Cat>();
        map.put("qw", new Cat("qw"));
        map.put("qw2", new Cat("qw2"));
        map.put("qw13", new Cat("qw13"));
        map.put("qw3312", new Cat("qw3312"));
        map.put("qwasds", new Cat("qwasds"));
        map.put("qwddasd", new Cat("qwddasd"));
        map.put("qwaasddas", new Cat("qwaasddas"));
        map.put("qwasdaddff", new Cat("qwasdaddff"));
        map.put("qwhhgfhgh", new Cat("qwhhgfhgh"));
        map.put("qwgfghdfghdfgh", new Cat("qwgfghdfghdfgh"));
        return map;

    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map)
    {
        HashSet<Cat> set = new HashSet<Cat>();

        for (Cat cat : map.values())
        {
            set.add(cat);
        }

       return set;
    }

    public static void printCatSet(Set<Cat> set)
    {
        for (Cat cat:set)
        {
            System.out.println(cat);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat "+this.name;
        }
    }


}
