package com.javarush.test.level26.lesson15.big01;


import java.util.Collection;
import java.util.HashMap;


/**
 * Created by Prog on 20.04.2016.
 */
public final class CurrencyManipulatorFactory
{
    private CurrencyManipulatorFactory()
    {
    }

    private static HashMap<String, CurrencyManipulator> manipulators = new HashMap<>();

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode){

        if (!manipulators.containsKey(currencyCode)){
            manipulators.put(currencyCode, new CurrencyManipulator(currencyCode));
        }

        return manipulators.get(currencyCode);
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators(){
        return manipulators.values();
    }
}
