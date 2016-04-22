package com.javarush.test.level26.lesson10.home01;


import java.util.concurrent.BlockingQueue;

/**
 * Created by Prog on 20.04.2016.
 */
public class Consumer implements Runnable
{
    private BlockingQueue queue;

    public Consumer(BlockingQueue queue)
    {
        this.queue = queue;
    }

    @Override
    public void run()
    {
        try {
            int i = 0;
            while (true) {

                System.out.println(queue.take().toString());
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
        }
    }
}
