package com.javarush.test.level26.lesson15.big01;

import java.util.HashMap;

/**
 2. Валют может быть несколько, поэтому нам понадобится фабрика, которая будет создавать и хранить манипуляторы.
 Создадим класс CurrencyManipulatorFactory со статическим методом getManipulatorByCurrencyCode(String currencyCode).
 В этом методе будем создавать нужный манипулятор, если он еще не существует, либо возвращать ранее созданный.
 Подумайте, где лучше хранить все манипуляторы.
 Сделайте так, чтобы невозможно было создавать объекты CurrencyManipulatorFactory класса
 */
public final class CurrencyManipulatorFactory
{
    static HashMap<String, CurrencyManipulator> map = new HashMap<>();

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode){
        return null;
    }
}
