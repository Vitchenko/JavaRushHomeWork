package com.javarush.test.level14.lesson06.home01;

public class RussianHen extends Hen
{

    @Override
    public int getCountOfEggsPerMonth()
    {
        return 5;
    }

    public String getDescription(){
        return super.getDescription() + " Моя страна - Russia. Я несу " + this.getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
