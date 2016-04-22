package com.javarush.test.level26.lesson10.home02;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Prog on 20.04.2016.
 */
public class Producer implements Runnable
{
    protected ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map)
    {
        this.map = map;
    }

    @Override
    public void run()
    {
        Thread currentThread = Thread.currentThread();
        int i = 1;
        while (!currentThread.isInterrupted())
        {

           /* if (!map.isEmpty())
            {*/
                System.out.println("Some text for " + i);
                i++;
                try
                {
                    Thread.sleep(500);
                }
                catch (InterruptedException e)
                {

                    System.out.println(String.format("[%s] thread was terminated", currentThread.getName()));
                }
            /*}*/
        }

    }
}
