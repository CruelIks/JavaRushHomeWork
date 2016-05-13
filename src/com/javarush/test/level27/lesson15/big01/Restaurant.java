package com.javarush.test.level27.lesson15.big01;


import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;

/**
 * Created by Prog on 26.04.2016.
 */
public class Restaurant
{
    public static void main(String args[]) throws IllegalArgumentException{

        Tablet tablet = new Tablet(5);
        Cook cook = new Cook("Amigo");
        tablet.addObserver(cook);

        Waitor waitor = new Waitor();
        cook.addObserver(waitor);

        tablet.createOrder();


    }
}
