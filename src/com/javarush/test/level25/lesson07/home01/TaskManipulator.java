package com.javarush.test.level25.lesson07.home01;

public class TaskManipulator implements Runnable, CustomThreadManipulator {

    Thread thread;



    public TaskManipulator(){



    }
    @Override
    public void run() {
        if(!thread.isInterrupted())
            System.out.println(thread.getName());

        try {
            while (!thread.isInterrupted()) {
                Thread.sleep(110);
                System.out.println(thread.getName());
            }
        } catch (InterruptedException e) {}
    }

    @Override
    public void start(String threadName)
    {
        thread = new Thread(this);
        thread.setName(threadName);
        thread.start();

    }

    @Override
    public void stop()
    {

        thread.interrupt();

    }
}
