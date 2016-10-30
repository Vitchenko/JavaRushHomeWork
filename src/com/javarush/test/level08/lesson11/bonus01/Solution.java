package com.javarush.test.level08.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
Используйте коллекции.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        //напишите тут ваш код
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> monthes = new ArrayList<String>();
        monthes.add("January");
        monthes.add("February");
        monthes.add("March");
        monthes.add("April");
        monthes.add("May");
        monthes.add("June");
        monthes.add("July");
        monthes.add("August");
        monthes.add("September");
        monthes.add("October");
        monthes.add("November");
        monthes.add("December");


        String month = buff.readLine();
        for(int i=0;i<monthes.size();i++){
            if (monthes.get(i).equals(month)){
                System.out.println(month + " is " +(i+1)+ " month");
            }
        }

    }

}
