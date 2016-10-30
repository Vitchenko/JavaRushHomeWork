package com.javarush.test.level06.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
Пример ввода:
3
2
15
6
17
Пример вывода:
2
3
6
15
17
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int arr1[] = new int[5];
        int arr2[];

        for (int i = 0; i < 5; i++)
        {
            arr1[i] = Integer.parseInt(reader.readLine());
        }

        arr2 = sort(arr1);

        for (int i = 0; i < arr2.length ; i++)
        {
            System.out.println(arr2[i]);
        }

    }

        private static int[] sort(int[] arr) {


        int tmp;
        for (int i = arr.length - 1; i > 0; i--)
        {
            for (int j = 0; j < i; j++)
            {
                if (arr[j] > arr[j + 1])
                {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }

        return arr;

        }


}

