package com.javarush.test.level08.lesson08.task04;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{


    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("Stallone1", new Date("JUNE 11 1980"));
        map.put("Stallone2", new Date("April 6 1980"));
        map.put("Stallone3", new Date("JUNE 1 1980"));
        map.put("Stallone4", new Date("JUNE 11 1985"));
        map.put("Stallone5", new Date("March 1 1986"));
        map.put("Stallone6", new Date("JUNE 1 1970"));
        map.put("Stallone7", new Date("December 1 1980"));
        map.put("Stallone8", new Date("JUNE 1 1980"));
        map.put("Stallone9", new Date("April 5 1981"));

       return map;

    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) throws ParseException
    {
        //напишите тут ваш код
        Iterator <Map.Entry<String, Date>> iter = map.entrySet().iterator();

        while (iter.hasNext()){
            Map.Entry <String, Date> pair =iter.next();
            Date dat=pair.getValue();

            SimpleDateFormat sdf = new SimpleDateFormat("M");
            int date =Integer.parseInt(sdf.format(dat));

            if (date>5 && date<9) iter.remove();
        }


//        Iterator <Map.Entry<String, Date>> iter1 = map.entrySet().iterator();
//        while (iter1.hasNext()){
//            Map.Entry <String, Date> pair1 =iter1.next();
//            Date dat=pair1.getValue();
//            String str = pair1.getKey();
//            System.out.println(str + " " + dat);
//        }


    }
}
