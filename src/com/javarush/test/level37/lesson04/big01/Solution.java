package com.javarush.test.level37.lesson04.big01;

import com.javarush.test.level37.lesson04.big01.male.MaleFactory;

/**
 * Created by viv on 23.12.2016.
 */
public class Solution
{
    public static void main(String[] args) {
        MaleFactory factory = new MaleFactory();
        System.out.println(factory.getPerson(10));
        System.out.println(factory.getPerson(15));
        System.out.println(factory.getPerson(40));


    }

}
