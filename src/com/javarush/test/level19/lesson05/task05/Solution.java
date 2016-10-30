package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, включая символы новой строки. Результат вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.Scanner;

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
        String s1="";

        StringBuilder sb = new StringBuilder();

        while ((s = reader.readLine()) != null){
            sb.append(s);
        }

        s=sb.toString();

        s1=s.replaceAll("[^A-Za-z0-9]","");

        writer.write(s1);

        reader.close();
        writer.close();
    }


}
