package com.javarush.test.level08.lesson11.home04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/* Минимальное из N чисел
1. Ввести с клавиатуры число N.
2. Считать N целых чисел и заполнить ими список - метод getIntegerList.
3. Найти минимальное число среди элементов списка - метод getMinimum.
*/

public class Solution
{
    public static void main(String[] args) throws Exception {
        List<Integer> integerList = getIntegerList();
        System.out.println(getMinimum(integerList));
    }

    public static int getMinimum(List<Integer> array) {
        // Найти минимум
        int min=array.get(0);
        for (int i=1;i<array.size();i++){
            if (min>array.get(i)){
                min=array.get(i);
            }
        }

        return min;
    }

    public static List<Integer> getIntegerList() throws IOException {
        //Тут создать и заполнить список
        Random r = new Random();

        List<Integer> list=new ArrayList<>();
        BufferedReader buff =new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(buff.readLine());

        for (int i=0;i<n;i++){
            list.add(Integer.parseInt(buff.readLine()));
            //list.add(r.nextInt(1000));
        }

        return list;
    }
}
