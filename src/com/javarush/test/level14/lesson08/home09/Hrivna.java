package com.javarush.test.level14.lesson08.home09;

/*
2. В отдельном файле создай класс Hrivna.
3. Наследуй класс Hrivna от класса Money.
4. В классе Hrivna реализуй метод getCurrencyName, который возвращает "HRN".
5. В отдельном файле создай класс USD.
6. Наследуй класс USD от класса Money.
7. В классе USD реализуй метод getCurrencyName, который возвращает "USD".
8. Подумай, объекты каких классов можно добавить в список(лист) allMoney.
9. Добавь в конструктор класса Person заполнение листа allMoney объектами всех возможных классов.*/

public class Hrivna extends Money{

    public Hrivna(double amount)
    {
        super(amount);
    }

    @Override
    public String getCurrencyName()
    {
        return "HRN";
    }
}
