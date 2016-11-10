package com.javarush.test.level26.lesson15.big01;

import java.util.HashMap;
import java.util.Map;

/**
 4. В классе CurrencyManipulator создайте метод void addAmount(int denomination, int count),
 который добавит введенные номинал и количество банкнот

 */
public class CurrencyManipulator
{
    /**String currencyCode - код валюты, например, USD. Состоит из трех букв
     Map<Integer, Integer> denominations - это Map<номинал, количество>*/

    private String currencyCode;
    public Map<Integer, Integer> denominations=new HashMap<>();


    public CurrencyManipulator(String currencyCode)
    {
        this.currencyCode = currencyCode;
    }


    public String getCurrencyCode()
    {
        return currencyCode;
    }

    public void addAmount(int denomination, int count){
        denominations.put(denomination,count);
    }


}
