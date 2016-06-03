package com.javarush.test.level30.lesson15.big01;

import java.io.Serializable;

/**
 * Created by Prog on 25.05.2016.
 */
public class Message implements Serializable
{
    private final MessageType type;
    private final String data;

    public Message(MessageType type)
    {
        this.type = type;
        data = null;
    }

    public Message(MessageType type, String data)
    {
        this.type = type;
        this.data = data;
    }

    public MessageType getType()
    {
        return type;
    }

    public String getData()
    {
        return data;
    }
}