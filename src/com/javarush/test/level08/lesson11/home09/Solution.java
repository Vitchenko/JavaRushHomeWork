package com.javarush.test.level08.lesson11.home09;

import java.text.SimpleDateFormat;
import java.util.Date;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года -
нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args)
    {
        String s = "january 3 1980";
        System.out.println(isDateOdd(s));

    }

    public static boolean isDateOdd(String date)
    {
        SimpleDateFormat format = new SimpleDateFormat("MMM dd yyyy");
        Date yearBegin = new Date(date);
        yearBegin.setHours(0);
        yearBegin.setMinutes(0);
        yearBegin.setSeconds(0);

        yearBegin.setDate(1);
        yearBegin.setMonth(0);

        Date dateNow = new Date(date);


        long difference = dateNow.getTime()  - yearBegin.getTime();
        long days = difference/(24*60*60*1000);

        System.out.println(format.format(yearBegin));
        System.out.println(format.format(dateNow));
        if(days % 2 != 0)
            return false;
        else return true;
    }

}
