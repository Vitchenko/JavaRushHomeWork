package com.javarush.test.level09.lesson11.home09;

import java.util.*;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap()
    {
        //напишите тут ваш код
        HashMap<String,Cat > map = new HashMap<>(10);
        Cat cat1=new Cat("ncat1");
        map.put("ncat1",cat1);
        Cat cat2=new Cat("ncat2");
        map.put("ncat2",cat2);

        Cat cat3=new Cat("ncat3");
        map.put("ncat3",cat3);
        Cat cat4=new Cat("ncat4");
        map.put("ncat4",cat4);

        Cat cat5=new Cat("ncat5");
        map.put("ncat5",cat5);
        Cat cat6=new Cat("ncat6");
        map.put("ncat6",cat6);

        Cat cat7=new Cat("ncat7");
        map.put("ncat7",cat7);
        Cat cat8=new Cat("ncat8");
        map.put("ncat8",cat8);

        Cat cat9=new Cat("ncat9");
        map.put("ncat9",cat9);
        Cat cat10=new Cat("ncat10");
        map.put("ncat10",cat10);

        return map;

    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map)
    {
        //напишите тут ваш код
        Set<Cat> set = new HashSet<>();
        //set=map.keySet();

        Iterator<Map.Entry<String, Cat>> iter = map.entrySet().iterator();

        while (iter.hasNext())
        {
            //получение «пары» элементов
            Map.Entry<String, Cat> pair = iter.next();
            //String key = pair.getKey();            //ключ
            set.add(pair.getValue());        //значение
            //System.out.println(key + ":" + value);
        }

        return set;
    }

    public static void printCatSet(Set<Cat> set)
    {
        for (Cat cat:set)
        {
            System.out.println(cat);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat "+this.name;
        }
    }


}
