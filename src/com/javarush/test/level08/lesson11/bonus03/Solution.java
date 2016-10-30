package com.javarush.test.level08.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Задача: Введи с клавиатуры 20 слов и выведи их в алфавитном порядке.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] array = new String[20];
        for (int i = 0; i < array.length; i++)
        {
            array[i] = reader.readLine();
        }

        //int[] list = {5, 6, 7, 8, 1, 2, 5, -7, -9, 2, 0};
//        array = new String[]{"now", "is", "the", "time", "for", "all", "good", "men", "toy", "come",
//                "to", "the", "aid", "of", "their", "country", "red", "better", "day", "cat"};


        sort(array);

        for (String x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(String[] array)
    {
        //напишите тут ваш код
        String tmp;
        for (int i=array.length-1;i>0;i--){
            for (int j=0;j<i;j++){
                if (array[j].compareTo(array[j+1])>0)
                {
                    tmp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=tmp;
                }
            }
        }

    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b)
    {
        return a.compareTo(b) > 0;
    }
}
