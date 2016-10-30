package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
        String fname=buff.readLine();
        //String fname="d:/3.txt";

        FileInputStream is=new FileInputStream(fname);
        byte [] b=new byte[is.available()];
        if (is.available()>0){
            int count=is.read(b);
        }

        String str="";
        for(int i=0;i<b.length;i++){
            str=str+(char)b[i];
        }

        int worldCount = 0;
        Pattern p = Pattern.compile("\\bworld\\b");

            Matcher m = p.matcher(str);
            while (m.find())
            {
                worldCount++;
            }


        System.out.println(worldCount);
        //System.out.println(count);

        buff.close();
        is.close();

    }
}
