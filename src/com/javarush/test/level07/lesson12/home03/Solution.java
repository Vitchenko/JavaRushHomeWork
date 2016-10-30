package com.javarush.test.level07.lesson12.home03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* Максимальное и минимальное числа в массиве
Создать массив на 20 чисел. Заполнить его числами с клавиатуры. Найти максимальное и минимальное числа в массиве.
Вывести на экран максимальное и минимальное числа через пробел.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arr=new ArrayList<>(20);
        Random r= new Random();
        int  maximum;
        int  minimum;

        //напишите тут ваш код
        for (int i=0;i<20;i++){
            arr.add(Integer.parseInt(reader.readLine()));
            //arr.add(r.nextInt(1000));
        }

        maximum=arr.get(0);
        for (int i=1;i<20;i++){
            if (arr.get(i)>maximum) {maximum=arr.get(i);}
        }

        minimum=arr.get(0);
        for (int i=1;i<20;i++){
            if (arr.get(i)<minimum) {minimum=arr.get(i);}
        }
        System.out.println(maximum + " " + minimum);

    }
}
