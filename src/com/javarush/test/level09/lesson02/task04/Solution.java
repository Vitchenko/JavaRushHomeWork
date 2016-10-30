package com.javarush.test.level09.lesson02.task04;

/* Стек-трейс длиной 10 вызовов
Напиши код, чтобы получить стек-трейс длиной 10 вызовов.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        method1();
    }

    public static StackTraceElement[] method1()
    {

        return method2();
         //Thread.currentThread().getStackTrace();
    }

    public static StackTraceElement[] method2()
    {
        //напишите тут ваш код
        return method3();
         //Thread.currentThread().getStackTrace();

    }

    public static StackTraceElement[] method3()
    {
        //напишите тут ваш код
        return method4();
         //Thread.currentThread().getStackTrace();

    }

    public static StackTraceElement[] method4()
    {
        //напишите тут ваш код
        return method5();
         //Thread.currentThread().getStackTrace();

    }

    public static StackTraceElement[] method5()
    {
        //напишите тут ваш код
        return method6();
         //Thread.currentThread().getStackTrace();

    }

    public static StackTraceElement[] method6()
    {
        //напишите тут ваш код
        return  method7();
        //Thread.currentThread().getStackTrace();

    }

    public static StackTraceElement[] method7()
    {
        //напишите тут ваш код
        return method8();
         //Thread.currentThread().getStackTrace();

    }

    public static StackTraceElement[] method8()
    {
        return method9();
         //Thread.currentThread().getStackTrace();

    }

    public static StackTraceElement[] method9()
    {
        return method10();

    }

    public static StackTraceElement[] method10()
    {
        return Thread.currentThread().getStackTrace();
    }
}
