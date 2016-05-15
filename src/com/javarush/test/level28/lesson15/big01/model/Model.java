package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.view.View;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 14.05.2016.
 */
public class Model
{
    private Provider[] providers;
    private View view;

    public Model(View view, Provider[] providers)
    {

        if (providers == null || view == null)
        {
            throw new IllegalArgumentException();
        }
        if (providers.length == 0)
        {
            throw new IllegalArgumentException();
        }

        this.providers = providers;
        this.view = view;
    }

    public void selectCity(String city){

        List<Vacancy> list = new ArrayList<>();

        for (Provider provider : providers)
        {

            list.addAll(provider.getJavaVacancies(city));

        }

        view.update(list);


    }
}
