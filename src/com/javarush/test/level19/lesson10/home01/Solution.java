package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        String fname1=args[0];
        //BufferedReader fr= new BufferedReader(new InputStreamReader((new FileInputStream(fname1)),"CP1251"));
        BufferedReader fr= new BufferedReader(new InputStreamReader((new FileInputStream(fname1))));

        TreeMap<String,Double> map = new TreeMap();
        String[] s;
        String key;
        Double val;


        while(fr.ready()){

            s=fr.readLine().split(" ");
            key=s[0];
            val=Double.parseDouble(s[1]);
            if (!map.containsKey(key)){
            map.put(key,val);}
            else{
                map.put(key,(map.get(key)+val));
            }

        }

        for (Map.Entry<String, Double> pair : map.entrySet())
        {
            String k = pair.getKey();
            Double v = pair.getValue();
            System.out.println(k + " " + v);
        }


        fr.close();


    }
}
