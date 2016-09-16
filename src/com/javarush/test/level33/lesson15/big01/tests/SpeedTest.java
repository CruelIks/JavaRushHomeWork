package com.javarush.test.level33.lesson15.big01.tests;

import com.javarush.test.level33.lesson15.big01.Helper;
import com.javarush.test.level33.lesson15.big01.Shortener;
import com.javarush.test.level33.lesson15.big01.strategies.HashBiMapStorageStrategy;
import com.javarush.test.level33.lesson15.big01.strategies.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Prog on 11.08.2016.
 */
public class SpeedTest
{

    public long getTimeForGettingIds(Shortener shortener, Set<String> strings, Set<Long> ids){

        Long start = new Date().getTime();
        for (String string : strings){
             ids.add(shortener.getId(string));
         }
        Long finish = new Date().getTime();

        return (finish - start);
    }

    public long getTimeForGettingStrings(Shortener shortener, Set<Long> ids, Set<String> strings){
        Long start = new Date().getTime();
        for (Long id : ids){
            strings.add(shortener.getString(id));
        }
        Long finish = new Date().getTime();

        return (finish - start);
    }

    @Test
    public void testHashMapStorage(){

        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());

        Set<String> origStrings = new HashSet<>();

        for (int i = 0; i < 1000 ; i++)
        {
            origStrings.add(Helper.generateRandomString());
        }

        Set<Long> ids1 = new HashSet<>();
        Long time1 = getTimeForGettingIds(shortener1, origStrings, ids1);
        Set<Long> ids2 = new HashSet<>();
        Long time2 = getTimeForGettingIds(shortener2, origStrings, ids2);

        Assert.assertTrue(time1 > time2);

        Set<String> strings1 = new HashSet<>();
        Set<String> strings2 = new HashSet<>();

        Long time3 = getTimeForGettingStrings(shortener1, ids1, strings1);
        Long time4 = getTimeForGettingStrings(shortener2, ids2, strings2);

        Assert.assertEquals(time3, time4, 5);

    }

}
