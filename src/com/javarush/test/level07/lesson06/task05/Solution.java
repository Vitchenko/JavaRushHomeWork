package com.javarush.test.level07.lesson06.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/* Удали последнюю строку и вставь её в начало
1. Создай список строк.
2. Добавь в него 5 строчек с клавиатуры.
3. Удали последнюю строку и вставь её в начало. Повторить 13 раз.
4. Используя цикл выведи содержимое на экран, каждое значение с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String > arr =new ArrayList<>();
        Random r=new Random();

        Date today = new Date();
        System.out.println("Current date: " + today);

        for (int i=0;i<5;i++){
        //    arr.add(buff.readLine());
          arr.add(String.valueOf(r.nextInt(1000)));
        }

        for (int i=0;i<13;i++)
        {
            String str;
            str=arr.get(arr.size()-1);
            arr.remove(arr.size()-1);
            arr.add(0,str);
        }

        for(String s:arr){
            System.out.println(s);
        }


    }
}
