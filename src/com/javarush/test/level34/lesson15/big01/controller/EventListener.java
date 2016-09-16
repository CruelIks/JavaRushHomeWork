package com.javarush.test.level34.lesson15.big01.controller;

import com.javarush.test.level34.lesson15.big01.model.Direction;

/**
 * Created by Prog on 15.09.2016.
 */
public interface EventListener
{
    void move(Direction direction);
    void restart();
    void startNextLevel();
    void levelCompleted(int level);

}
