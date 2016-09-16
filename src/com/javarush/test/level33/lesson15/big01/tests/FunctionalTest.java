package com.javarush.test.level33.lesson15.big01.tests;

import com.javarush.test.level33.lesson15.big01.Helper;
import com.javarush.test.level33.lesson15.big01.Shortener;
import com.javarush.test.level33.lesson15.big01.strategies.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Prog on 11.08.2016.
 */
public class FunctionalTest
{
    public void testStorage(Shortener shortener){
        String string1 = Helper.generateRandomString();
        String string2 = Helper.generateRandomString();
        String string3 = string1;

        Long id1 = shortener.getId(string1);
        Long id2 = shortener.getId(string2);
        Long id3 = shortener.getId(string3);

        Assert.assertNotEquals(id2, id1);
        Assert.assertNotEquals(id2, id3);
        Assert.assertEquals(id1, id3);

        String getString1 = shortener.getString(id1);
        String getString2 = shortener.getString(id2);
        String getString3 = shortener.getString(id3);

        Assert.assertEquals(getString1, string1);
        Assert.assertEquals(getString2, string2);
        Assert.assertEquals(getString3, string3);

    }

    @Test
    public void testHashMapStorageStrategy(){
        StorageStrategy strategy = new HashMapStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
    }

    @Test
    public void testOurHashMapStorageStrategy(){
        StorageStrategy strategy = new OurHashMapStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
    }

    @Test
    public void testFileStorageStrategy(){
        StorageStrategy strategy = new FileStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
    }

    @Test
    public void testHashBiMapStorageStrategy(){
        StorageStrategy strategy = new HashBiMapStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
    }

    @Test
    public void testDualHashBidiMapStorageStrategy(){
        StorageStrategy strategy = new DualHashBidiMapStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
    }

    @Test
    public void testOurHashBiMapStorageStrategy(){
        StorageStrategy strategy = new OurHashBiMapStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
    }
}
