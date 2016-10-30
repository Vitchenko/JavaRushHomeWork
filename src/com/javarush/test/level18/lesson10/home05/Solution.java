package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {


    public static void main(String[] args) throws IOException
    {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String fname1=reader.readLine();
        String fname2=reader.readLine();

//        String fname1="d:/1.txt";
//        String fname2="d:/2.txt";


        FileInputStream inputStream=new FileInputStream(fname1);
        FileOutputStream outputStream=new FileOutputStream(fname2);

        StringBuilder sb = new StringBuilder();
        String str;
        int data = inputStream.read();
        while(data != -1) {
            sb.append((char) data);
            data = inputStream.read();
        }

        str=sb.toString();
        String[] ss = str.split(" ");
        ArrayList<Integer> arr=new ArrayList<>();

        for (int i=0;i<ss.length;i++)
        {
           arr.add(Math.round(Float.parseFloat(ss[i])));
        }

        StringBuilder sb1 = new StringBuilder();
        for (int i=0;i<arr.size();i++){

            sb1.append(arr.get(i).toString());
            sb1.append(" ");
        }

        outputStream.write(sb1.toString().getBytes());

        reader.close();
        inputStream.close();
        outputStream.close();

    }
}
