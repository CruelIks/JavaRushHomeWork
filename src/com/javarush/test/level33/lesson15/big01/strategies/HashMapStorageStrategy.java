package com.javarush.test.level33.lesson15.big01.strategies;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Prog on 12.07.2016.
 */
public class HashMapStorageStrategy implements StorageStrategy
{

    private final HashMap<Long, String> data = new HashMap<>();

    @Override
    public boolean containsKey(Long key)
    {

        return data.containsKey(key);
    }

    @Override
    public boolean containsValue(String value)
    {
        return data.containsValue(value);
    }

    @Override
    public void put(Long key, String value)
    {
        data.put(key, value);

    }

    @Override
    public Long getKey(String value)
    {
        for (Map.Entry<Long, String> longStringEntry : data.entrySet())
        {

            if (longStringEntry.getValue().equals(value)){
                return longStringEntry.getKey();
            }
        }

        return null;
    }

    @Override
    public String getValue(Long key)
    {
        return data.get(key);
    }
}
