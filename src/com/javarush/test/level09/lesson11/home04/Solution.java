package com.javarush.test.level09.lesson11.home04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* Конвертер дат
Ввести с клавиатуры дату в формате «08/18/2013»
Вывести на экран эту дату в виде «AUG 18, 2013».
Воспользоваться объектом Date и SimpleDateFormat.
*/

public class Solution
{

    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String sdate = buff.readLine();
        //String sdate="08/18/2013";


        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        Date date = sdf.parse(sdate);

        SimpleDateFormat sdf1 = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
        String date1 = sdf1.format(date);


        System.out.println(date1.toUpperCase());

//        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
//        String date = sdf.format(new Date());
//        System.out.println(date); //15/10/2013
    }
}
