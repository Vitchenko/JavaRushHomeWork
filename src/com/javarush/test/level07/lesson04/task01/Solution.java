package com.javarush.test.level07.lesson04.task01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/* Максимальное среди массива на 20 чисел
1. В методе initializeArray():
1.1. Создайте массив на 20 чисел
1.2. Считайте с консоли 20 чисел и заполните ими массив
2. Метод max(int[] array) должен находить максимальное число из элементов массива
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int[] array = initializeArray();
        int max = max(array);
        System.out.println(max);
    }

    public static int[] initializeArray() throws IOException {
        //Инициализируйте (создайте и заполните) массив тут
        int[] arr = new int[20];
        BufferedReader burr = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0;i<20;i++){
            arr[i] = Integer.parseInt(burr.readLine());
        }
//        Random r =new Random();
//        for (int i=0;i<20;i++){
//            arr[i] = r.nextInt(100);
//            System.out.println(arr[i]);
//        }
//        System.out.println();
        return arr;
    }

    public static int max(int[] array) {
        //Найдите максимальное значение в этом методе
        int tmp;
        for (int i=array.length-1;i>0; i--){
            for (int j=0; j<i; j++){
                if (array[j]>array[j+1]){
                    tmp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=tmp;
                }
            }
        }



        return array[array.length-1];
    }
}
