package com.javarush.test.level30.lesson04.home01;

import javax.swing.table.TableCellRenderer;
import java.util.concurrent.TransferQueue;

/**
 * Created by Prog on 25.05.2016.
 */
public class Consumer implements Runnable
{
    private TransferQueue<ShareItem> queue;

    public Consumer(TransferQueue<ShareItem> queue)
    {
        this.queue = queue;
    }

    @Override
    public void run()
    {

        try
        {
            Thread.currentThread().sleep(500);

            while (true){
                System.out.println("Processing " + queue.take().toString());
            }
        }
        catch (InterruptedException e)
        {
            return;
        }


    }
}
