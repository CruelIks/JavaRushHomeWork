package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

/**
 * Created by Prog on 20.04.2016.
 */
public class ConsoleHelper
{
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "common_en");

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
        writeMessage(res.getString("choose.currency.code"));

        while (true)
        {
            code = readString().trim();

            if (code.length() != 3)
            {
                writeMessage(res.getString("invalid.data"));
            } else break;

        }

        return code.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException
    {

        String[] array;
        writeMessage(res.getString("choose.denomination.and.count.format"));
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
                writeMessage(res.getString("invalid.data"));
            }

            writeMessage(res.getString("invalid.data"));
        }

        return array;
    }

    public static void printExitMessage(){

        writeMessage(res.getString("the.end"));
    }
    public static Operation askOperation() throws InterruptOperationException{

        writeMessage(res.getString("choose.operation"));
        writeMessage("1 - INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT");
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
                writeMessage(res.getString("invalid.data"));
                continue;
            }
            catch (IllegalArgumentException e)
            {
                writeMessage(res.getString("invalid.data"));
                continue;
            }
        }
        return result;
    }
}
