package com.javarush.test.level08.lesson06.task02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/* Провести 10 тысяч вставок, удалений
Для arrayList и linkedList провести 10 тысяч вставок, удалений, а также вызовов get и set.
*/

public class Solution
{

    public static void main(String[] args) throws Exception
    {


        // ArrayList
        ArrayList arrayList = new ArrayList();
        insert10000(arrayList);
        get10000(arrayList);
        set10000(arrayList);
        remove10000(arrayList);

        // LinkedList
        LinkedList linkedList = new LinkedList();
        insert10000(linkedList);
        get10000(linkedList);
        set10000(linkedList);
        remove10000(linkedList);
    }

    public static void insert10000(List list)
    {
        Random r=new Random();
        //напишите тут ваш код
        for (int i=0;i<10000;i++){
            list.add(r.nextInt(1000));
        }

    }

    public static void get10000(List list)
    {
        //напишите тут ваш код
        Object ob;
        for (int i=0;i<10000;i++){
            ob=list.get(i);
        }

    }

    public static void set10000(List list)
    {
        //напишите тут ваш код
        Random r=new Random();
        //напишите тут ваш код
        for (int i=0;i<10000;i++){
            list.set(i,r.nextInt(1000));
        }

    }

    public static void remove10000(List list)
    {
        //напишите тут ваш код
        //for (int i=0;i<10000;i++){

        while (list.size()>0){
            list.remove(0);

        }
    }
}
