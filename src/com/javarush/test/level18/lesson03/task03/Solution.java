package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;


/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        ArrayList<Byte> arr=new ArrayList();
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String f1=reader.readLine();
        //String f1="d:/1.txt";

        FileInputStream inputStream = new FileInputStream(f1);
        TreeMap<Integer,Byte> map = new TreeMap(Collections.reverseOrder());

        while (inputStream.available() > 0) //пока есть еще непрочитанные байты
        {
            arr.add((byte) inputStream.read());
        }

        for (int i=0;i<arr.size();i++){
            int count = Collections.frequency(arr, arr.get(i));
            map.put(count,arr.get(i));
        }

        arr.clear();
        for (Map.Entry<Integer, Byte> pair : map.entrySet())
        {

            Byte value = pair.getValue();
            arr.add(value);

        }

        System.out.println(arr.get(0)+" ");
        for (int i=1;i<arr.size();i++){
            if(arr.get(0)==arr.get(i)){
                System.out.println(arr.get(i)+" ");
            }
        }



        reader.close();
        inputStream.close();


    }
}
