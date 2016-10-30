package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;
import java.util.ArrayList;
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

        StringBuilder sb = new StringBuilder();

        while ((s = reader.readLine()) != null){
            sb.append(s);
        }
        s=sb.toString();
        String[] strArr=s.split(" ");

        for(int i=0;i<strArr.length;i++){
            try {
                int val=Integer.parseInt(strArr[i]);
                writer.write(val+" ");
            }catch (Exception e){
            }
        }
        reader.close();
        writer.close();
    }
}
