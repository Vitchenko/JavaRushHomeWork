package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки. Не использовать try-with-resources

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
        String fname=buff.readLine();
        //String fname="d:/1.txt";

        FileInputStream inp=new FileInputStream(fname);
        int fsize=inp.available();
        byte[] buffer = new byte[0];
        int zpt=0;

        if (inp.available() > 0) {
            buffer = new byte[inp.available()];
            int count = inp.read(buffer);
        }

        for (int i=0;i<buffer.length;i++){
            if (buffer[i]==44){zpt++;}

        }

        System.out.println(zpt);
        inp.close();
        buff.close();


    }
}
