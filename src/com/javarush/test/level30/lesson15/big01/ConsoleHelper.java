package com.javarush.test.level30.lesson15.big01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Prog on 25.05.2016.
 */
public class ConsoleHelper
{
    private final static BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString(){

        String result = null;
        while (true)
        {
            try
            {
                result = READER.readLine();
                break;
            }
            catch (IOException e)
            {
                writeMessage("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            }
        }

        return result;
    }

    public static int readInt(){

        int result = 0;

        while (true){

            String str = readString();
            try{

                result = Integer.parseInt(str);
                break;

            }
            catch (NumberFormatException e) {
                writeMessage("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
            }

        }
        return result;
    }
}
