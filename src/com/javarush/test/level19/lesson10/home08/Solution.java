package com.javarush.test.level19.lesson10.home08;

/* Перевертыши
1 Считать с консоли имя файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке
2.2 вывести на экран
3 Закрыть потоки. Не использовать try-with-resources

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/

import java.io.*;


public class Solution {
    public static void main(String[] args) throws IOException
    {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();


        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

        String str;


        while (fileReader.ready())
        {
            StringBuffer sb=new StringBuffer();
            sb.append(fileReader.readLine());
            System.out.println(sb.reverse());
        }

        bufferedReader.close();
        fileReader.close();

    }
}
