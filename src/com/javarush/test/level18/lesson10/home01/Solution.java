package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        String fname=args[0];
        int bukv=0;

        FileInputStream fs=new FileInputStream(fname);

        try
        {
            byte[] buf=new byte[fs.available()];
            while(fs.available()>0){
                int count=fs.read(buf);
            }

            for(int i=0;i<buf.length;i++){
                if ((char)buf[i]>64 && (char)buf[i]<123){
                    bukv++;
                }
            }
            System.out.println(bukv);

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            fs.close();
        }
    }
}
