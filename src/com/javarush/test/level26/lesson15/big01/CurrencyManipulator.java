package com.javarush.test.level26.lesson15.big01;

import java.util.HashMap;
import java.util.Map;

/**
 Задание 3
 1. Создадим класс CurrencyManipulator, который будет хранить всю информацию про выбранную
 валюту.
 String currencyCode - код валюты, например, USD. Состоит из трех букв
 Map<Integer, Integer> denominations - это Map<номинал, количество>
 Чтобы можно было посмотреть, к какой валюте относится манипулятор, добавим геттер для currencyCode
 Очевидно, что манипулятор никак не может функционировать без названия валюты,
 поэтому добавим конструктор с этим параметром и проинициализируем currencyCode



 */
public class CurrencyManipulator
{
    public String currencyCode;
    public Map<Integer, Integer> denominations=new HashMap<>();
    public String getCurrencyCode()
    {
        return currencyCode;
    }

    public CurrencyManipulator(String currencyCode)
    {
        this.currencyCode = currencyCode;
    }



}
