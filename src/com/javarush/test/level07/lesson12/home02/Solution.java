package com.javarush.test.level07.lesson12.home02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

/* Переставить M первых строк в конец списка
Ввести с клавиатуры 2 числа N  и M.
Ввести N строк и заполнить ими список.
Переставить M первых строк в конец списка.
Вывести список на экран, каждое значение с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        ArrayList<String> arr=new ArrayList<>();
        ArrayList<String> arr2=new ArrayList<>();
        Random r = new Random();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int nStr = Integer.parseInt(reader.readLine());
        int mStr = Integer.parseInt(reader.readLine());

//        int nStr =10;
//        int mStr =4;
        for (int i=0;i<nStr;i++){
            arr.add(reader.readLine());
            //arr.add(String.valueOf(r.nextInt(1000)));
        }

//        for(String s:arr){
//        System.out.println(s);
//        }
//        System.out.println("-------------");

        for (int i=arr.size()-(arr.size()-mStr);i<arr.size();i++){
            arr2.add(arr.get(i));
        }

        for (int i=0;i<mStr;i++){
            arr2.add(arr.get(i));
        }
        //System.arraycopy(arr,arr.size()-(arr.size()-mStr)+1,arr2,0,arr.size()-mStr);

        //System.arraycopy(arr,0,arr2,arr.size()-mStr+1,mStr);

        for(String s:arr2){
            System.out.println(s);
        }
    }
}
