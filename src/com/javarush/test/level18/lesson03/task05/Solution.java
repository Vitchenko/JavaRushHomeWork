package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;




/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String f1=reader.readLine();
        //String f1="d:/1.txt";

        FileInputStream inputStream = new FileInputStream(f1);
        // Создаем поток-записи-байт-в-файл

        int fsize=inputStream.available();

        TreeSet<Byte> set = new TreeSet<>();

        while (inputStream.available() > 0) //пока есть еще непрочитанные байты
        {
            set.add((byte) inputStream.read());
        }

        //System.out.println(set.toString());
        for(byte b:set){
            System.out.print(b+" ");
        }



        reader.close();
        inputStream.close(); //закрываем оба потока. Они больше не нужны.


    }
}
