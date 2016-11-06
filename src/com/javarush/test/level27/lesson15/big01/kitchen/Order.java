package com.javarush.test.level27.lesson15.big01.kitchen;

import java.util.ArrayList;

/**
 4. В классе Order (заказ) должна быть информация, относящаяся к списку выбранных пользователем блюд.
 Т.е. где-то должен быть список всех блюд, и должен быть список выбранных блюд в классе Order.
 Нам нужен класс Dish(Блюдо), создадим его в пакете kitchen. Пусть это будет энум с какими-то данными,
 например, Fish, Steak, Soup, Juice, Water
 */
public class Order
{
    ArrayList <Dish> allDishs=new ArrayList<>();
    ArrayList <Dish> choiseDishs=new ArrayList<>();
}
