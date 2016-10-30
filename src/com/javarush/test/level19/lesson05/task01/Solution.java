package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
        String fname1=buff.readLine();
        String fname2=buff.readLine();

//        String fname1="d:/1.txt";
//        String fname2="d:/2.txt";

        FileInputStream inputStream = new FileInputStream(fname1);
        FileOutputStream outputStream = new FileOutputStream(fname2);
        byte[] buffer = new byte[inputStream.available()];
        int count= inputStream.read(buffer);

        for (int i=0;i<buffer.length;i++){
            if (i%2!=0){
                outputStream.write(buffer[i]);
            }
        }

        buff.close();
        inputStream.close();
        outputStream.close();
    }
}
