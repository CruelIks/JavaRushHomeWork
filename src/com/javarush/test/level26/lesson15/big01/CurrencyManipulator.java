package com.javarush.test.level26.lesson15.big01;


import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.*;

/**
 * Created by Prog on 20.04.2016.
 */
public class CurrencyManipulator
{
    private String currencyCode;
    private Map<Integer, Integer> denominations = new HashMap<>();

    public String getCurrencyCode()
    {
        return currencyCode;
    }

    public CurrencyManipulator(String currencyCode)
    {
        this.currencyCode = currencyCode;
    }

    public void addAmount(int denomination, int count)
    {

        if (denominations.containsKey(denomination))
            denominations.put(denomination, denominations.get(denomination) + count);
        else
            denominations.put(denomination, count);
    }

    public int getTotalAmount()
    {
        int result = 0;

        for (Integer integer : denominations.keySet())
        {
            result += integer * denominations.get(integer);
        }

        return result;
    }

    public boolean isAmountAvailable(int expectedAmount)
    {

        if (getTotalAmount() < expectedAmount) return false;
        else return true;

    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException
    {

        int getingAmount = 0;
        int needAmount = expectedAmount;

        Map<Integer, Integer> temp = new HashMap<>();
        temp.putAll(denominations);

        Map<Integer, Integer> map = new HashMap<>();

        ArrayList<Integer> denom = new ArrayList<>();
        denom.addAll(temp.keySet());

        Collections.sort(denom);
        Collections.reverse(denom);

        TreeMap<Integer, Integer> result = new TreeMap<>(new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return o2.compareTo(o1);
            }


        });

        for (Integer i : denom)
        {

            int countAllBanknot;
            int countBanknot = 0;
            while ((countAllBanknot = temp.get(i)) > 0)
            {

                if (i > (needAmount)) break;

                getingAmount += i;
                needAmount -= i;
                temp.put(i, countAllBanknot - 1);
                countBanknot++;

            }

            if (countBanknot > 0)
            {
                result.put(i, countBanknot);
            }

            if (getingAmount == expectedAmount) break;
        }

        if (getingAmount < expectedAmount) throw new NotEnoughMoneyException();

        denominations.clear();
        denominations.putAll(temp);

        for (Integer integer : result.keySet())
        {
            ConsoleHelper.writeMessage("\t" + integer + " - " + result.get(integer));
        }

        ConsoleHelper.writeMessage("the operation was successful");


        return result;
    }

    public boolean hasMoney()
    {
        return (denominations.size() > 0);
    }
}
