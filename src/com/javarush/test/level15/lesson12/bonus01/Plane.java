package com.javarush.test.level15.lesson12.bonus01;


//2. Класс Plane должен иметь 1 конструктор с параметром int - количество перевозимых пассажиров.
public class Plane implements Flyable{

    private int pass;

    public Plane(int pass)
    {
        this.pass = pass;
    }
        @Override
        public void fly ()
        {

        }

}
