package com.javarush.test.level33.lesson15.big01;

import com.javarush.test.level33.lesson15.big01.strategies.*;

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Prog on 04.08.2016.
 */
public class Solution
{
    public static Set<Long> getIds(Shortener shortener, Set<String> strings)
    {

        Set<Long> result = new HashSet<>();

        for (String s : strings)
        {
            result.add(shortener.getId(s));
        }

        return result;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys)
    {

        Set<String> result = new HashSet<>();

        for (Long key : keys)
        {
            result.add(shortener.getString(key));
        }

        return result;

    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber)
    {

        Helper.printMessage(strategy.getClass().getSimpleName());

        //generate set string
        Set<String> startStrings = new HashSet<>();

        for (int i = 0; i < elementsNumber; i++)
        {
            startStrings.add(Helper.generateRandomString());
        }

        //create shortener, use our strategy
        Shortener shortener = new Shortener(strategy);

        //test getIds
        Date date = new Date();
        long msStart = date.getTime();
        Helper.printMessage("Test getIds");

        Set<Long> setIds = getIds(shortener, startStrings);
        date = new Date();
        long msFinish = date.getTime();
        Helper.printMessage("Время прохождения теста: " + (msFinish - msStart) + " ms");

        //test getStrings
        date = new Date();
        msStart = date.getTime();
        Helper.printMessage("Test getStrings");

        Set<String> setStrings = getStrings(shortener, setIds);

        date = new Date();
        msFinish = date.getTime();
        Helper.printMessage("Время прохождения теста: " + (msFinish - msStart) + " ms");

        //compare setStrings
        if (setStrings.equals(startStrings))
        {
            Helper.printMessage("Тест пройден.");
        } else
        {
            Helper.printMessage("Тест не пройден.");
        }


    }

    public static void main(String[] args)
    {
        /*StorageStrategy strategy = new HashMapStorageStrategy();
        testStrategy(strategy, 2000);

        StorageStrategy newStrategy = new OurHashMapStorageStrategy();
        testStrategy(newStrategy, 2000);*/

        StorageStrategy newStrategy = new HashBiMapStorageStrategy();
        testStrategy(newStrategy, 2000);

    }
}
