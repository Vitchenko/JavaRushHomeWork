package com.javarush.test.level27.lesson15.big01;


import com.javarush.test.level27.lesson15.big01.kitchen.Cook;

/**
 * Created by viv on 06.11.2016.
 */
public class Restaurant
{
    public static void main(String[] args)
    {

        Cook cook = new Cook("Amigo");


        Tablet tablet = new Tablet(5);
        tablet.addObserver(cook);
        tablet.createOrder();
    }

}
