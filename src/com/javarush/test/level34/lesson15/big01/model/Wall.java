package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

/**
 * Created by Prog on 15.09.2016.
 */
public class Wall extends CollisionObject
{

    public Wall(int x, int y)
    {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics)
    {
        graphics.setColor(new Color(150, 75, 0));
        graphics.drawRect(getX(), getY(), getWidth(), getHeight());
    }
}
