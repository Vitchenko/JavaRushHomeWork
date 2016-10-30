package com.javarush.test.level08.lesson08.task02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/* Удалить все числа больше 10
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.
*/

public class Solution
{
    public static HashSet<Integer> createSet()
    {
        //напишите тут ваш код
        Set <Integer> set = new HashSet<>();
        Random r = new Random();
        for (int i=0;i<20;i++){
            set.add(r.nextInt(1000));
        }

        return (HashSet<Integer>) set;
    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set)
    {
        //напишите тут ваш код
        Iterator<Integer> iter = set.iterator();
        while (iter.hasNext()){
            if(iter.next()>10){
                iter.remove();
            }
        }
        return set;
    }
}
