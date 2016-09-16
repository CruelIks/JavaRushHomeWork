package com.javarush.test.level33.lesson10.home01;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Prog on 12.08.2016.
 */

@XmlType(name = "shop")
@XmlRootElement
public class Shop
{

    @XmlElementWrapper(name = "goods", nillable = true)
    public List<String> names = new ArrayList<>();

    public int count;

    public double profit;

    public List<String> secretData = new ArrayList<>();

    @Override
    public String toString()
    {
        return "Shop{" +
                "goods=" + getGoodsToString() +
                ", count=" + count +
                ", profit=" + profit +
                ", secretData=" + getSecretDataToString() +
                '}';
    }


    private String getSecretDataToString()
    {

        String result = "";
        for (String s : secretData)
        {
            result += s;
            result += ", ";
        }

        return result;
    }

    private String getGoodsToString()
    {
        String result = "";
        for (String good : names)
        {
            result += good + ", ";
        }

        return result;
    }



}
