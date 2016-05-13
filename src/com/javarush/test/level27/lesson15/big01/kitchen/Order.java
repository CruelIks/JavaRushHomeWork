package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.List;

/**
 * Created by Prog on 26.04.2016.
 */
public class Order
{
    private Tablet tablet;
    private List<Dish> dishes;

    public Order(Tablet tablet) throws IOException
    {
        this.tablet = tablet;
        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }

    public boolean isEmpty()
    {
        return dishes.isEmpty();

    }

    public int getTotalCookingTime()
    {
        int result = 0;

        for (Dish dish : dishes)
        {
            result += dish.getDuration();
        }
        return result;
    }

    @Override
    public String toString()
    {
        if (dishes.isEmpty()) return "";

        StringBuilder str = new StringBuilder("");
        for (Dish dish : dishes)
        {
            str.append(dish.name()).append(", ");
        }
        str.delete(str.length() - 2, str.length());

        return String.format("Your order: [%s] of %s", str.toString(), tablet);

    }

    public Tablet getTablet()
    {
        return tablet;
    }

    public List<Dish> getDishes()
    {
        return dishes;
    }
}
