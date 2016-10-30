package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fname1=reader.readLine();
        String fname2=reader.readLine();
        String fname3=reader.readLine();

//        String fname1="d:/1.txt";
//        String fname2="d:/2.txt";
//        String fname3="d:/3.txt";

        FileInputStream inputStream = new FileInputStream(fname2);
        FileOutputStream outputStream = new FileOutputStream(fname1);
        while (inputStream.available() > 0) //пока есть еще непрочитанные байты
        {
            int data = inputStream.read(); // прочитать очередной байт в переменную data
            outputStream.write(data); // и записать его во второй поток
        }
        reader.close();
        inputStream.close(); //закрываем оба потока. Они больше не нужны.
        outputStream.close();

        FileInputStream inputStream1 = new FileInputStream(fname3);
        FileOutputStream outputStream1 = new FileOutputStream(fname1,true);


        byte[] buffer = new byte[inputStream1.available()];
        while (inputStream1.available() > 0) //пока есть еще непрочитанные байты
        {
            // прочитать очередной блок байт в переменную buffer и реальное количество в count
            int count = inputStream1.read(buffer);
            outputStream1.write(buffer, 0 , count); //записать блок(часть блока) во второй поток
        }



        inputStream1.close(); //закрываем оба потока. Они больше не нужны.
        outputStream1.close();




    }




}
