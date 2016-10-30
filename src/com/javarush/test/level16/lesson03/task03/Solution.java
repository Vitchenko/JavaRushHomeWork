package com.javarush.test.level16.lesson03.task03;

import java.util.ArrayList;
import java.util.List;

/* Список и нити
В методе main добавить в статический объект list 5 нитей SpecialThread - различных объектов.
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {
        //Add your code here - добавьте свой код тут
        SpecialThread tr1=new SpecialThread();
        SpecialThread tr2=new SpecialThread();
        SpecialThread tr3=new SpecialThread();
        SpecialThread tr4=new SpecialThread();
        SpecialThread tr5=new SpecialThread();

        list.add(new Thread(tr1));
        list.add(new Thread(tr2));
        list.add(new Thread(tr3));
        list.add(new Thread(tr4));
        list.add(new Thread(tr5));

    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's run method inside SpecialThread");
        }
    }
}
