package com.javarush.test.level14.lesson08.home05;

public class Computer{

    private Keyboard Keyboard;
    private Mouse Mouse;
    private Monitor Monitor;

    public Computer()
    {
        Keyboard = new Keyboard();
        Monitor=new Monitor();
        Mouse=new Mouse();
    }


    public Keyboard getKeyboard()
    {
        return Keyboard;
    }

    public Mouse getMouse()
    {
        return Mouse;
    }

    public Monitor getMonitor()
    {
        return Monitor;
    }
}
