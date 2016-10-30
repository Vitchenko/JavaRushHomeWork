package com.javarush.test.level07.lesson09.task01;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* Три массива
1. Введи с клавиатуры 20 чисел, сохрани их в список и рассортируй по трём другим спискам:
Число делится на 3 (x%3==0), делится на 2 (x%2==0) и все остальные.
Числа, которые делятся на 3 и на 2 одновременно, например 6, попадают в оба списка.
2. Метод printList должен выводить на экран все элементы списка с новой строки.
3. Используя метод printList выведи эти три списка на экран. Сначала тот, который для x%3, потом тот, который для x%2, потом последний.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        Random r= new Random();
        ArrayList<Integer> arr3 =new ArrayList<Integer>();
        ArrayList<Integer> arr2 =new ArrayList<Integer>();
        ArrayList<Integer> arrall =new ArrayList<Integer>();
        BufferedReader buff= new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> arr =new ArrayList<Integer>();
        for (int i=0;i<20;i++){
            arr.add(Integer.parseInt(buff.readLine()));
//            arr.add(r.nextInt(1000));
        }
//        arr.add(4);
//        arr.add(6);
//        arr.add(6);
//        arr.add(5);
//        arr.add(6);
//        arr.add(3);
//        arr.add(2);
//        arr.add(1);
//        arr.add(9);
//        arr.add(12);
//        arr.add(6);
//        arr.add(6);
//        arr.add(5);
//        arr.add(4);
//        arr.add(6);
//        arr.add(3);
//        arr.add(2);
//        arr.add(1);
//        arr.add(9);
//        arr.add(12);


        for (int i=0;i<20;i++){
            if (arr.get(i)%3==0 && arr.get(i)%2==0){
                arr3.add(arr.get(i));
                arr2.add(arr.get(i));
            }else if (arr.get(i)%3==0)
            {
                arr3.add(arr.get(i));
            }else if (arr.get(i)%2==0)
            {
                arr2.add(arr.get(i));
            }else {arrall.add(arr.get(i));}
        }

        printList(arr3);
        printList(arr2);
        printList(arrall);

    }

    public static void printList(List<Integer> list)
    {
        //напишите тут ваш код
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        System.out.println();
    }
}
