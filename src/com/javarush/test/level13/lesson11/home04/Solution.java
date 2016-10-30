package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args)  throws IOException
    {
        String s;

        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        File flt =new File(b.readLine());
        PrintWriter wrt = new PrintWriter(flt);

        while ((s=b.readLine())!=null)
        {
            if (s.equals("exit"))
            {wrt.println(s);
                wrt.flush();
                break;}

            else
            {
                wrt.println(s);
                wrt.flush();
            }

        }
        wrt.close();

    }



}
