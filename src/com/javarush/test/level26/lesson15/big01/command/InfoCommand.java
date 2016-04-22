package com.javarush.test.level26.lesson15.big01.command;


import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Prog on 21.04.2016.
 */
class InfoCommand implements Command
{
    @Override
    public void execute() throws InterruptOperationException
    {

        boolean hasMoney = false;
        for (CurrencyManipulator cur : CurrencyManipulatorFactory.getAllCurrencyManipulators()){
            if(cur.hasMoney()) hasMoney = true;
            break;
        }
        if (!hasMoney) {
            ConsoleHelper.writeMessage("No money available.");
            return;
        }

        for (CurrencyManipulator cur : CurrencyManipulatorFactory.getAllCurrencyManipulators())
        {
            int total = cur.getTotalAmount();
            ConsoleHelper.writeMessage(cur.getCurrencyCode() + " - " + total);

        }
    }
}
