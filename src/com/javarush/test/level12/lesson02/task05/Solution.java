package com.javarush.test.level12.lesson02.task05;

/* Или «Корова», или «Кит», или «Собака», или «Неизвестное животное»
Написать метод, который определяет, объект какого класса ему передали, и возвращает результат – одно значение из:
«Корова», «Кит», «Собака», «Неизвестное животное».
*/

public class Solution
{
    public static void main(String[] args)
    {
        System.out.println(getObjectType(new Cow()));
        System.out.println(getObjectType(new Dog()));
        System.out.println(getObjectType(new Whale()));
        System.out.println(getObjectType(new Pig()));
    }

    public static String getObjectType(Object o)
    {
        //Напишите тут ваше решение
        String str=null;
        if (o instanceof Cow) {str= "Корова";}
        if (o instanceof Dog) {str="Собака";}
        if (o instanceof Whale) {str="Кит";}
        if (o instanceof Pig) {str= "Неизвестное животное";}

        return str;
    }

    public static class Cow
    {
    }

    public static class Dog
    {
    }

    public static class Whale
    {
    }

    public static class Pig
    {
    }
}
