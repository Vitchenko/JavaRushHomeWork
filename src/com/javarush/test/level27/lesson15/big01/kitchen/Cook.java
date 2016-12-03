package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;


public class Cook extends Observable implements Observer
{
    private String cookName;

    public Cook(String cookName)
    {
        this.cookName = cookName;
    }

    @Override
    public String toString()
    {
        return "Cook{" + "cookName='" + cookName + '\'' +'}';
    }


    @Override
    public void update(Observable o, Object arg)
    {
        ConsoleHelper.writeMessage("Start cooking - " + arg);
    }


}
