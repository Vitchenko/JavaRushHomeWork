package com.javarush.test.level14.lesson06.home01;

import com.javarush.test.level14.lesson06.home01.Hen;

public class UkrainianHen extends Hen
{

    @Override
    public int getCountOfEggsPerMonth()
    {
        return 6;
    }

    public String getDescription(){
        return super.getDescription() + " Моя страна - Ukraine. Я несу " + this.getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
