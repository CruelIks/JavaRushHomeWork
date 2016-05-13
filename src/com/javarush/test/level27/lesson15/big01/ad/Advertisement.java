package com.javarush.test.level27.lesson15.big01.ad;

/**
 * Created by Prog on 04.05.2016.
 */
public class Advertisement
{
    private Object content; //видео
    private String name;    //имя
    private long initialAmount;  //стоимость показа
    private int hits;   //количество оплаченных показов
    private int duration;  //продолжительность
    private long amountPerOneDisplaying; //стоимости одного показа рекламного объявления в копейках

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration)
    {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        this.amountPerOneDisplaying = hits == 0 ? 0 : initialAmount / hits;
    }

    public String getName()
    {
        return name;
    }

    public int getDuration()
    {
        return duration;
    }

    public long getAmountPerOneDisplaying()
    {
        return amountPerOneDisplaying;
    }

    public void revalidate()
    {
        if (hits <= 0)
        {
            throw new UnsupportedOperationException();
        }
        hits--;

    }

    public int getHits()
    {
        return hits;
    }
}
