package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by Prog on 02.03.2016.
 */
public class Singleton
{

    private static Singleton singleton;


    public static Singleton getInstance()
    {

        if (null == singleton) singleton = new Singleton();


        return singleton;

    }

    private Singleton()
    {

    }

}
