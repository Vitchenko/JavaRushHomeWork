package com.javarush.test.level13.lesson11.home03;

/* Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть освободить ресурсы. Закрыть поток чтения с файла и поток ввода с клавиатуры.
*/

import java.io.*;

import static java.lang.System.in;


public class Solution
{
    public static void main(String[] args) throws IOException
    {
        //add your code here

        BufferedReader buff = new BufferedReader(new InputStreamReader(in));
        String fstr = buff.readLine();

        InputStream inStream = new FileInputStream(fstr);
        //StringBuffer sbuff=new StringBuffer();
        OutputStream out = new PrintStream (System.out);

        while (inStream.available() > 0)
        {
            int data = inStream.read(); //читаем один байт из потока для чтения
            //sbuff.append(String.valueOf(data));
            out.write(data);
        }

        //System.out.println(sbuff);
        inStream.close(); //закрываем потоки
        out.close();
        buff.close();


    }
}
