package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Prog on 29.02.2016.
 */
public class BelarusianHen extends Hen
{

    @Override
    public int getCountOfEggsPerMonth()
    {
        return 10;
    }

    @Override
    public String getDescription()
    {
        return super.getDescription() + " Моя страна - " + Country.BELARUS + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
