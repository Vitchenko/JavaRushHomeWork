package com.javarush.test.level26.lesson15.big01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



/**
 Задание 4
 1. Выберем операцию, с которой мы сможем начать.
 Подумаем. В банкомате еще денег нет, поэтому INFO и WITHDRAW протестить не получится.
 Начнем с операции DEPOSIT - поместить деньги.
 Считаем с консоли код валюты, потом считаем номинал и количество банкнот, а потом добавим их в манипулятор.

 2. Чтобы считать код валюты, добавим статический метод String askCurrencyCode() в ConsoleHelper.
 Этот метод должен предлагать пользователю ввести код валюты, проверять, что код содержит 3 символа.
 Если данные некорректны, то сообщить об этом пользователю и повторить.
 Если данные валидны, то перевести код в верхний регистр и вернуть.

 3. Чтобы считать номинал и количество банкнот, добавим статический метод String[] getValidTwoDigits(String currencyCode) в ConsoleHelper.
 Этот метод должен предлагать пользователю ввести два целых положительных числа.
 Первое число - номинал, второе - количество банкнот.
 Никаких валидаторов на номинал нет. Т.е. 1200 - это нормальный номинал.
 Если данные некорректны, то сообщить об этом пользователю и повторить.
 Пример вводимых данных:
 200 5

 4. В классе CurrencyManipulator создайте метод void addAmount(int denomination, int count),
 который добавит введенные номинал и количество банкнот

 5. Пора уже увидеть приложение в действии.
 В методе main захардкодь логику пункта 1.
 Кстати, чтобы не было проблем с тестами на стороне сервера, добавь в метод main первой строчкой Locale.setDefault(Locale.ENGLISH);
 Запускаем, дебажим, смотрим.
 */
public class ConsoleHelper
{
    static final BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString() throws IOException
    {
        return bf.readLine();
    }

    public static String askCurrencyCode() throws IOException
    {

        String strInVal;
        while(true){
            System.out.println("Input valute code? ");
            strInVal=readString();
            if(strInVal.length()==3){
                return strInVal.toUpperCase();
            }else{
                System.out.println("Valute code incorrect. Repeat please?");
            }
        }
    }

    public static String[] getValidTwoDigits(String currencyCode) throws IOException
    {

        String[] strArrInVal;
        while(true){
            System.out.println("Input two digital. First - nominal, Second - banknots qantity?");
            strArrInVal=readString().split(" ");

            if(strArrInVal.length==2 && checkString(strArrInVal[0]) && checkString(strArrInVal[1])){

                return strArrInVal;
            }else{
                System.out.println("Incorrect. \"200 5\" Repast please");
            }
        }

    }

    public static boolean checkString(String string) {
        if (string == null) return false;
        return string.matches("^-?\\d+$");
    }

}
