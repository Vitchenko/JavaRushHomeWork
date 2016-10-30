package com.javarush.test.level08.lesson08.task05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
//    public static void main(String[] args)
//    {
//        HashMap<String, String> map=new HashMap<String, String>();
//        map=createMap();
//        removeTheFirstNameDuplicates(map);
//
//        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
//
//        while (iterator.hasNext())
//        {
//            Map.Entry<String, String> pair = iterator.next();
//            System.out.println(pair.getKey()+ " - " + pair.getValue());        //значение
//        }
//
//    }

    public static HashMap<String, String> createMap()
    {
        //напишите тут ваш код
        HashMap<String, String> map=new HashMap<String, String>();
        map.put("Ivanov","Ivan2");
        map.put("Ivanov2","Ivan");
        map.put("Ivanov3","I");
        map.put("Ivanov4","Ivan");
        map.put("Ivanov5","Ivan");

        map.put("Ivanov6","In");
        map.put("Ivanov7","Ian");
        map.put("Ivanov8","Ivan");
        map.put("Ivanov9","Ivan");
        map.put("Ivanov10","Ivan");

        return map;

    }

    public static void removeTheFirstNameDuplicates(HashMap <String, String> map)
    {
        //напишите тут ваш код
//        ArrayList<String> vals = new ArrayList<>();
//
//        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
//
//        while (iterator.hasNext())
//        {
//            Map.Entry<String, String> pair = iterator.next();
//            vals.add(pair.getValue());        //значение
//        }
//
//        Iterator<Map.Entry<String, String>> iter = map.entrySet().iterator();
//
//        for (int i=0; i < vals.size();  i++)
//        {
//            int count=0;
//            while (iter.hasNext())
//            {
//
//                Map.Entry<String, String> pair1 = iter.next();
//                String s1=pair1.getKey();
//                String s2=pair1.getValue();
//                String s3=vals.get(i);
//
//                if (s2.equals(s3))
//                {
//                  count++;
//                }
//                if (count>1) {
//                    removeItemFromMapByValue(map,s3);
//                }
//
//            }
//
//        }

        HashMap<String, String> copy1 = new HashMap<String, String>(map);
        HashMap<String, String> copy2 = new HashMap<String, String>(map);

        //в первом цикле берем первое имя из первой копии
        for (Map.Entry<String, String> pair1: copy1.entrySet())
        {
            int count = 0;

            //во втором цикле сравниваем первое имя из первой копии со всеми именами
            //из второй копии, если одно совпадение, то имя встречается один раз,
            //если больше одного, то несколько и его надо удалить в исходной МамеМапе)))

            for (Map.Entry<String, String> pair2 : copy2.entrySet())
            {
                if (pair1.getValue().equals(pair2.getValue()))
                {
                    count++;
                }
            }

            //то есть, если больше одного совпадения, то удаляем в главной мапе
            //все позиции с нужным именем с помощью любезно предоставленного нам метода
            if (count > 1)
            {
                removeItemFromMapByValue(map, pair1.getValue());
            }
        }
    }

    public static void removeItemFromMapByValue(HashMap<String,String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
