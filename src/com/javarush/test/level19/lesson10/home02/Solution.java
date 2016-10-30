package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.*;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        String fname1 = args[0];
        //BufferedReader fr= new BufferedReader(new InputStreamReader((new FileInputStream(fname1)),"CP1251"));
        BufferedReader fr = new BufferedReader(new InputStreamReader((new FileInputStream(fname1))));

        TreeMap<String, Double> map = new TreeMap();
        String[] s;
        String key;
        Double val;


        while (fr.ready())
        {

            s = fr.readLine().split(" ");
            key = s[0];
            val = Double.parseDouble(s[1]);
            if (!map.containsKey(key))
            {
                map.put(key, val);
            } else
            {
                map.put(key, (map.get(key) + val));
            }

        }

        TreeSet<Double> ts=new TreeSet<>();

        for (Map.Entry<String, Double> pair : map.entrySet())
        {
            String k = pair.getKey();
            Double v = pair.getValue();
            //System.out.println(k + " " + v);
            ts.add(v);
        }

        //System.out.println("--------------------------");

        Double lev=ts.last();
        for(Double d:ts){
            if(d>=lev){

                for (Map.Entry<String, Double> pair : map.entrySet())
                {
                    String k = pair.getKey();
                    Double v = pair.getValue();
                    if(v==lev){
                        System.out.println(k);
                    }
                }


            }
        }

        fr.close();


    }
}
