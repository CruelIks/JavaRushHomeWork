package com.javarush.test.level27.lesson15.big01.kitchen;


import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Prog on 29.04.2016.
 */
public class Waitor implements Observer
{

    @Override
    public void update(Observable o, Object arg)
    {
        ConsoleHelper.writeMessage(arg + " was cooked by " + o.toString());
    }
}
