package com.javarush.test.level29.lesson15.big01.human;


public class BloodGroup
{
    private final int code;

    private BloodGroup(int code)
    {
        this.code = code;
    }

    public int getCode()
    {
        return code;
    }

    public BloodGroup first(){return new BloodGroup(1);}
    public BloodGroup second(){return new BloodGroup(2);}
    public BloodGroup third(){return new BloodGroup(3);}
    public BloodGroup fourth(){return new BloodGroup(4);}
}
