package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<String, String>();

        map.put("Ivanov","Ivan");
        map.put("Petrov","Petr");
        map.put("Sidorov","Carl");
        map.put("Demen","Ivan");
        map.put("Dementev","Van");
        map.put("Ivanov1","Ivan");
        map.put("Petrov2","Petr");
        map.put("Sidorov3","Carl");
        map.put("Demen4","Ivan");
        map.put("Dementev5","Van");

        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        //напишите тут ваш код
        Iterator<Map.Entry<String, String>> iter = map.entrySet().iterator();
        int val=0;

        while(iter.hasNext()){
            Map.Entry<String, String> pair=iter.next();
            String im = pair.getValue();
            if ( im.equals(name)){
                val++;}
        }

        return val;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName)
    {
        Iterator<Map.Entry<String, String>> iter = map.entrySet().iterator();
        int val=0;

        while(iter.hasNext()){
            Map.Entry<String, String> pair=iter.next();
            String im = pair.getKey();
            if ( im.equals(lastName)){
                val++;}
        }

        return val;

    }
}
