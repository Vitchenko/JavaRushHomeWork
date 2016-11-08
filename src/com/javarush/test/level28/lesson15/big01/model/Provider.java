package com.javarush.test.level28.lesson15.big01.model;

/**
 * Created by viv on 08.11.2016.
 */
public class Provider
{
    Strategy strategy;

    public Provider(Strategy strategy)
    {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy)
    {
        this.strategy = strategy;
    }
}
