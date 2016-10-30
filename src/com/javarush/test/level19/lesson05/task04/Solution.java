package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        Scanner handler = new Scanner(System.in);
        String file1 = handler.nextLine();
        String file2 = handler.nextLine();
//        String file1 = "d:/1.txt";
//        String file2 = "d:/2.txt";
        handler.close();

        BufferedReader reader = new BufferedReader(new FileReader(file1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(file2));

        String s;
        String s1;

        StringBuilder sb = new StringBuilder();

        while ((s = reader.readLine()) != null){
            sb.append(s);
        }

        s=sb.toString();

        s1=s.replaceAll("\\.","!");

        writer.write(s1);

        reader.close();
        writer.close();
    }


}
