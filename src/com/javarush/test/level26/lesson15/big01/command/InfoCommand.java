package com.javarush.test.level26.lesson15.big01.command;


import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by Prog on 21.04.2016.
 */
class InfoCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "info_en");

    @Override
    public void execute() throws InterruptOperationException
    {

        boolean hasMoney = false;
        ConsoleHelper.writeMessage(res.getString("before"));
        for (CurrencyManipulator cur : CurrencyManipulatorFactory.getAllCurrencyManipulators()){
            if(cur.hasMoney()) hasMoney = true;
            break;
        }
        if (!hasMoney) {
            ConsoleHelper.writeMessage(res.getString("no.money"));
            return;
        }

        for (CurrencyManipulator cur : CurrencyManipulatorFactory.getAllCurrencyManipulators())
        {
            int total = cur.getTotalAmount();
            ConsoleHelper.writeMessage(cur.getCurrencyCode() + " - " + total);

        }
    }
}
