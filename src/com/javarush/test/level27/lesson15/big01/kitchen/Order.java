package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.ConsoleHandler;

/**

 4. Перепишите метод toString в классе Order. Пусть он возвращает пустую строку, если нет блюд в заказе, иначе
 вывод должен быть аналогичный примеру в порядке добавления блюд. Используйте ConsoleHelper.
 Пример:
 Your order: [Juice, Fish] of Tablet{number=5}
 */
public class Order
{
    private ArrayList <Dish> allDishes=new ArrayList<>();
    private ArrayList <Dish> choiseDishes=new ArrayList<>();

    private List<Dish> dishes;

    public Order(List<Dish> dishes)
    {
        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }

    @Override
    public String toString()
    {
        return "Order{" +
                "allDishs=" + allDishes +
                ", choiseDishs=" + choiseDishes +
                ", dishes=" + dishes +
                '}';
    }
}
