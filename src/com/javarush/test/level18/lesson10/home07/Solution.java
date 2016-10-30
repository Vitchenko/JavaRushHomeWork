package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки. Не использовать try-with-resources

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int

Информация по каждому товару хранится в отдельной строке
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {

        int id=Integer.parseInt(args[0]);
        BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
        String fname1= null;

        try
        {
            fname1 = buff.readLine();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        BufferedReader br1 = null;

        try {

            String str;
            br1 = new BufferedReader(new FileReader(fname1));

            while ((str= br1.readLine()) != null) {

                if(id==Integer.parseInt(str.substring(0,str.indexOf(" ")))){
                    System.out.println(str);
                }

            }



        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br1 != null)br1.close();
                if (buff != null)buff.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }


    }
}
