package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Prog on 20.04.2016.
 */
public class ConsoleHelper
{
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message)
    {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException
{
        String result = "";
        try
        {
            result = reader.readLine();

            if (result.toLowerCase().equals("exit")) throw new InterruptOperationException();
        }
        catch (IOException e)
        {
        }


        return result;

    }

    public static String askCurrencyCode() throws InterruptOperationException
    {

        String code = "";
        writeMessage("enter currency code (3 num's):");

        while (true)
        {
            code = readString().trim();

            if (code.length() != 3)
            {
                writeMessage("bad code. try again");
            } else break;

        }

        return code.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException
    {

        String[] array;
        writeMessage("enter DENOMINATION and COUNT:");
        while (true)
        {

            try
            {
                String str = readString();
                array = str.split(" ");
                if (array.length == 2) {

                    int num1 = Integer.parseInt(array[0]);
                    int num2 = Integer.parseInt(array[1]);

                    if ((num1 != 0) && (num2 != 0)) break;

                }

            }
            catch (Exception e){
                writeMessage("incorrect data found. try again");
            }

            writeMessage("incorrect data found. try again");
        }

        return array;
    }

    public static Operation askOperation() throws InterruptOperationException{

        writeMessage("select operation: 1 - INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT");
        String str;
        Operation result;

        while (true)
        {
            str = readString();
            try
            {
                int number = Integer.parseInt(str);
                result = Operation.getAllowableOperationByOrdinal(number);
                break;

            }
            catch (NumberFormatException e)
            {
                writeMessage("bad data try again");
                continue;
            }
            catch (IllegalArgumentException e)
            {
                writeMessage("bad data try again");
                continue;
            }
        }
        return result;
    }
}
