package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fname1=reader.readLine();
        String fname2=reader.readLine();


        FileInputStream inputStream1 = new FileInputStream(fname1);
        FileInputStream inputStream2 = new FileInputStream(fname2);


        byte[] buffer1 = new byte[inputStream1.available()];
        while (inputStream1.available() > 0)
        {
            int count = inputStream1.read(buffer1);
        }

        byte[] buffer2 = new byte[inputStream2.available()];
        while (inputStream2.available() > 0) //пока есть еще непрочитанные байты
        {
            int count2 = inputStream2.read(buffer2);
        }

        byte[] buffer3=new byte[buffer1.length+buffer2.length];
        System.arraycopy(buffer2,0,buffer3,0,buffer2.length);
        System.arraycopy(buffer1,0,buffer3,buffer2.length,buffer1.length);

        FileOutputStream fs=new FileOutputStream(fname1);

           fs.write(buffer3);




        inputStream1.close();
        inputStream2.close();
        fs.close();
        reader.close();


    }
}
