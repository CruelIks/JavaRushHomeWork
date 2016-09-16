package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

/**
 * Created by Prog on 15.09.2016.
 */
public class Home extends GameObject
{

    public Home(int x, int y)
    {
        super(x, y, 2, 2);
    }

    @Override
    public void draw(Graphics graphics)
    {
        graphics.setColor(new Color(255, 0, 0));
        graphics.drawOval(getX(), getY(), getWidth(), getHeight());

    }
}
