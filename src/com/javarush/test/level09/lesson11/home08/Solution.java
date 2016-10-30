package com.javarush.test.level09.lesson11.home08;

import java.util.ArrayList;
import java.util.Random;

/* Список из массивов чисел
Создать список, элементами которого будут массивы чисел. Добавить в список пять объектов–массивов длиной 5, 2, 4, 7, 0
соответственно. Заполнить массивы любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList()
    {
        //напишите тут ваш код

        ArrayList<int[]> arr=new ArrayList<int[]>();

        arr.add(createArr(5));
        arr.add(createArr(2));
        arr.add(createArr(4));
        arr.add(createArr(7));
        arr.add(createArr(0));

        return arr;
    }

    public static int[] createArr(int num){

        Random r = new Random();
        int[] arr=new int[num];

        for (int i=0;i<arr.length;i++){
            arr[i]=r.nextInt(1000);
        }

        return arr;
    }

    public static void printList(ArrayList<int[]> list)
    {
        for (int[] array: list )
        {
            for (int x: array)
            {
                System.out.println(x);
            }
        }
    }
}
