package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

/**Что мы имеем? Повар приготовил блюда, пора их уносить, а официант не знает об этом.
 Нужно уведомить официанта, что пора забирать заказ с кухни.
 Ситуация аналогична предыдущему заданию, поэтому снова будем использовать паттерн Observer.

 1. Создадим класс Waitor(Официант) в пакете kitchen, он будет относить заказы назад к столику. Официант будет безымянный.

 2. Cook(Повар) готовит заказы, а Waitor их обрабатывает. Расставьте правильно Observer и Observable между Waitor и Cook.

 3. Метод void update пусть выведет в консоль следующее:
 order + " was cooked by " + cook

 4. В классе-Observable перед отправкой заказа сделаем следующее:
 4.1. Установим флаг setChanged()
 4.2. Отправим обсерверу заказ notifyObservers(order);

 5. Пишем main.
 Для объекта Observable добавляем свой объект Observer. См. п.2 и описание паттерна в wikipedia
 Называем повара, имя не влияет на тесты. В моем варианте - это Amigo :)

 Сверим выводы в консоль. Пример моего вывода:
 Your order: [Water] of Tablet{number=5}
 Start cooking - Your order: [Water] of Tablet{number=5}
 Your order: [Water] of Tablet{number=5} was cooked by Amigo */
public class Waitor implements Observer
{
    @Override
    public void update(Observable o, Object arg)
    {
        ConsoleHelper.writeMessage(arg + " was cooked by " + o);
    }
}
