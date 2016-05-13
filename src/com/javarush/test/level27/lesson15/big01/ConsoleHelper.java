package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Prog on 26.04.2016.
 */
public class ConsoleHelper
{
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message)
    {
        System.out.println(message);
    }

    public static String readString() throws IOException
    {

        String result = null;
        result = reader.readLine();
        return result;
    }

    public static List<Dish> getAllDishesForOrder() throws IllegalArgumentException, IOException
    {
        List<Dish> list = new ArrayList<>();

        String dishName = null;
        String allDishes = Dish.allDishesToString();
        writeMessage("Choose dishes : " + allDishes);

        while (true)
        {

            dishName = readString();

            if (dishName.equalsIgnoreCase("exit")) break;


            try
            {
                list.add(Dish.valueOf(dishName));
            }
            catch (IllegalArgumentException e)
            {
                writeMessage(dishName + " is not detected");
            }

        }


        return list;
    }
}
