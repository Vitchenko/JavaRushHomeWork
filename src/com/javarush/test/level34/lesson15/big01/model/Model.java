package com.javarush.test.level34.lesson15.big01.model;

import com.javarush.test.level34.lesson15.big01.controller.EventListener;

/**
 * Created by viv on 19.12.2016.
 */
public class Model
{
    public static int FIELD_SELL_SIZE = 20;
    EventListener eventListener;

    public void setEventListener(EventListener eventListener){
        this.eventListener=eventListener;
    }



}
