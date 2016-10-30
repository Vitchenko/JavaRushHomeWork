package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
        String str;
        TreeSet<String> set=new TreeSet();

        while(!(str=buff.readLine()).equals("end")){
            set.add(str);
        }

        String fOutName=set.first().substring(0,set.first().lastIndexOf("."));
        BufferedOutputStream out=new BufferedOutputStream(new FileOutputStream(fOutName));

        for(String fname:set){
            BufferedInputStream in=new BufferedInputStream(new FileInputStream(fname));
            byte[] b=new byte[in.available()];
            int count=in.read(b);
            out.write(b);
            out.flush();
            in.close();
        }

        out.close();
        buff.close();


    }
}
