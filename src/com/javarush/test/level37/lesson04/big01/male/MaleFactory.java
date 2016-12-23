package com.javarush.test.level37.lesson04.big01.male;

import com.javarush.test.level37.lesson04.big01.Human;

/**
 * Created by viv on 23.12.2016.
 */
public class MaleFactory
{

    public Human getPerson(int age)
    {

        if (age <= KidBoy.MAX_AGE)
        {
            return new KidBoy();
        } else if (age <= TeenBoy.MAX_AGE && age > KidBoy.MAX_AGE)
        {
            return new TeenBoy();
        } else
        {
            return new Man();
        }
    }
}