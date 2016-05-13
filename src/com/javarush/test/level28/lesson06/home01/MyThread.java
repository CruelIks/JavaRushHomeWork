package com.javarush.test.level28.lesson06.home01;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Prog on 12.05.2016.
 */
public class MyThread extends Thread
{
    private static AtomicInteger count = new AtomicInteger(0);

    public MyThread()
    {

        int priority = count.incrementAndGet() % 10;
        priority = priority == 0 ? 10 : priority;
        setPriority(priority);

    }

    public MyThread(Runnable target)
    {
        super(target);
        int priority = count.incrementAndGet() % 10;
        priority = priority == 0 ? 10 : priority;
        setPriority(priority);

    }

    public MyThread(ThreadGroup group, Runnable target)
    {
        super(group, target);

        int maxPriority = group.getMaxPriority();
        int priority = count.incrementAndGet() % 10;
        priority = priority == 0 ? 10 : priority;
        priority = priority < maxPriority ? priority : maxPriority;

        setPriority(priority);


    }

    public MyThread(String name)
    {
        super(name);
        int priority = count.incrementAndGet() % 10;
        priority = priority == 0 ? 10 : priority;
        setPriority(priority);

    }

    public MyThread(ThreadGroup group, String name)
    {
        super(group, name);
        int maxPriority = group.getMaxPriority();
        int priority = count.incrementAndGet() % 10;
        priority = priority == 0 ? 10 : priority;
        priority = priority < maxPriority ? priority : maxPriority;

        setPriority(priority);
    }

    public MyThread(Runnable target, String name)
    {
        super(target, name);
        int priority = count.incrementAndGet() % 10;
        priority = priority == 0 ? 10 : priority;
        setPriority(priority);

    }

    public MyThread(ThreadGroup group, Runnable target, String name)
    {
        super(group, target, name);

        int maxPriority = group.getMaxPriority();
        int priority = count.incrementAndGet() % 10;
        priority = priority == 0 ? 10 : priority;
        priority = priority < maxPriority ? priority : maxPriority;

        setPriority(priority);

    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize)
    {
        super(group, target, name, stackSize);

        int maxPriority = group.getMaxPriority();
        int priority = count.incrementAndGet() % 10;
        priority = priority == 0 ? 10 : priority;
        priority = priority < maxPriority ? priority : maxPriority;

        setPriority(priority);

    }
}
