package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.command.CommandExecutor;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.Locale;

/**
 * Created by Prog on 20.04.2016.
 */
public class CashMachine
{
    public static final String RESOURCE_PATH = "com.javarush.test.level26.lesson15.big01.resources.";
    public static void main(String args[])
    {

        Locale.setDefault(Locale.ENGLISH);
        try
        {
            Operation operation = null;
            CommandExecutor.execute(Operation.LOGIN);

            do
            {
                operation = ConsoleHelper.askOperation();
                CommandExecutor.execute(operation);
            }
            while (operation != Operation.EXIT);
        }
        catch (InterruptOperationException e)
        {

            try
            {
                CommandExecutor.execute(Operation.EXIT);
            }
            catch (InterruptOperationException ignored)
            {
            }

        }
        ConsoleHelper.printExitMessage();


    }


}
