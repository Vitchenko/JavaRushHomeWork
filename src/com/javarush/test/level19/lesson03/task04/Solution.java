package com.javarush.test.level19.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке.
Метод read() должен читать данные одного человека.
*/

public class Solution
{
    public static class PersonScannerAdapter implements PersonScanner
    {

        Scanner sc;

        public PersonScannerAdapter(Scanner sc)
        {
            this.sc = sc;
        }

        @Override
        public Person read() throws IOException
        {
            Person p;

            String str=this.sc.nextLine();
            String[] arr=str.split(" ");
            Date date=null;
            SimpleDateFormat formatter = new SimpleDateFormat("dd MM yyyy");
            String dateInString =arr[3]+" "+arr[4]+" "+arr[5];
            try
            {
                date = formatter.parse(dateInString);
            }
            catch (ParseException e)
            {
                e.printStackTrace();
            }
            p = new Person(arr[1], arr[2], arr[0], date);
            return p;
        }


        @Override
        public void close() throws IOException
        {
            this.sc.close();
        }
    }
}