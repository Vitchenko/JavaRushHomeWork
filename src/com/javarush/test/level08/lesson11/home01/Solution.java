package com.javarush.test.level08.lesson11.home01;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* Set из котов
1. Внутри класса Solution создать public static класс кот – Cat.
2. Реализовать метод createCats, он должен создавать множество (Set) котов и добавлять в него 3 кота.
3. В методе main удалите одного кота из Set cats.
4. Реализовать метод printCats, он должен вывести на экран всех котов, которые остались во множестве.
Каждый кот с новой строки.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Set<Cat> cats = createCats();

        //напишите тут ваш код. пункт 3
        Iterator<Cat> iterator = cats.iterator();

            iterator.next();
            iterator.remove();



        //cats.remove()
        printCats(cats);
    }

    public static Set<Cat> createCats()
    {
        //напишите тут ваш код. пункт 2
        Set<Cat> mcat = new HashSet<>();

        Cat cat1=new Cat();
        cat1.name="Vasiy";
        mcat.add(cat1);

        Cat cat2=new Cat();
        cat2.name="Dashs";
        mcat.add(cat2);

        Cat cat3=new Cat();
        cat3.name="DD";
        mcat.add(cat3);

        return mcat;
    }

    public static void printCats(Set<Cat> cats)
    {
        // пункт 4
        for(Cat c:cats){
            System.out.println(c);
        }
    }

    public static class Cat{
        String name;

    }
}
