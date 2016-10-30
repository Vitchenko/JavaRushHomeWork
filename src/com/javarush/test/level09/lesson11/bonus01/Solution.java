package com.javarush.test.level09.lesson11.bonus01;

import java.io.*;

/* Нужно исправить программу, чтобы компилировалась и работала
Задача: Программа вводит два имени файла. И копирует первый файл на место заданное вторым именем.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String sourceFileName = reader.readLine();
        String destinationFileName = reader.readLine();

//        String sourceFileName = "d:/1.txt";
//        String destinationFileName = "d:/2.txt";


        FileInputStream fileInputStream = new FileInputStream(sourceFileName);
        FileOutputStream fileOutputStream = new FileOutputStream(destinationFileName);


        int ccc=fileInputStream.available();
        int count = 0;

       // while (ccc>0);
        //{

        for (int i=0;i<ccc;i++){
            int data = fileInputStream.read();
            fileOutputStream.write(data);
            count++;
        //    ccc--;
        }
        //}

        System.out.println("Скопировано байт " + count);

        fileInputStream.close();
        fileOutputStream.close();
    }
}
