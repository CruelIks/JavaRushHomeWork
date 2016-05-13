package com.javarush.test.level27.lesson15.big01.statistic;

import com.javarush.test.level27.lesson15.big01.statistic.event.EventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Prog on 06.05.2016.
 */
public class StatisticManager
{
    private final static StatisticManager instance = new StatisticManager();
    private static StatisticStorage statisticStorage = new StatisticStorage();

    private StatisticManager()
    {
    }

    public static StatisticManager getInstance()
    {

        return instance;
    }

    public void register(EventDataRow data){
        statisticStorage.put(data);
    }

    private static class StatisticStorage{

        private Map<EventType, List<EventDataRow>> map = new HashMap<>();

        public StatisticStorage()
        {

            for (EventType event : EventType.values()){
                map.put(event, new ArrayList<EventDataRow>());
            }
        }

        private void put(EventDataRow data){

            map.get(data.getType()).add(data);

        }

        public Map<EventType, List<EventDataRow>> getMap()
        {
            return map;
        }
    }
}
