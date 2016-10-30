package com.javarush.test.level14.lesson06.home01;

public class BelarusianHen extends Hen
{

    @Override
    public int getCountOfEggsPerMonth()
    {
        return 8;
    }

    public String getDescription(){
        return super.getDescription() + " Моя страна - Belarus. Я несу " + this.getCountOfEggsPerMonth() + " яиц в месяц.";
        //<" Моя страна - Sssss. Я несу N яиц в месяц.">
    }

}
