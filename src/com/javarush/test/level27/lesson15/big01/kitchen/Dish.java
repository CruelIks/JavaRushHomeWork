package com.javarush.test.level27.lesson15.big01.kitchen;

/**
 * Created by Prog on 26.04.2016.
 */
public enum Dish
{
    Fish(25), Steak(30), Soup(15), Juice(5), Water(3);

    private int duration;

    public int getDuration()
    {
        return duration;
    }

    Dish(int duration)
    {
        this.duration = duration;
    }

    public static String allDishesToString(){
        StringBuilder str = new StringBuilder();
        for(Dish dish : values()){
            str.append(dish.name()).append(", ");
        }
        str.delete(str.length() - 2, str.length());
        return str.toString();
    }
}
