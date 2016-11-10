package com.javarush.test.level26.lesson15.big01;

import java.io.IOException;
import java.util.Locale;

import static com.javarush.test.level26.lesson15.big01.ConsoleHelper.getValidTwoDigits;
import static com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory.getManipulatorByCurrencyCode;

/**
 * Created by viv on 02.11.2016.
 */
public class CashMachine
{
    /**5. Пора уже увидеть приложение в действии.
В методе main захардкодь логику пункта 1.
Кстати, чтобы не было проблем с тестами на стороне сервера, добавь в метод main первой строчкой Locale.setDefault(Locale.ENGLISH);
Запускаем, дебажим, смотрим.
     1. Выберем операцию, с которой мы сможем начать.
     Подумаем. В банкомате еще денег нет, поэтому INFO и WITHDRAW протестить не получится.
     Начнем с операции DEPOSIT - поместить деньги.
     Считаем с консоли код валюты, потом считаем номинал и количество банкнот, а потом добавим их в манипулятор.

     */

    public static void main(String[] args) throws IOException
    {
        Locale.setDefault(Locale.ENGLISH);
        String strCodVal= ConsoleHelper.askCurrencyCode();
        String[] arrDenCount=getValidTwoDigits(strCodVal);
        CurrencyManipulator cn=getManipulatorByCurrencyCode(strCodVal);
        cn.addAmount(Integer.parseInt(arrDenCount[0]),Integer.parseInt(arrDenCount[1]));
    }

}
