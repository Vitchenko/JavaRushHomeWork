package com.javarush.test.level19.lesson10.home03;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException
    {

        String fname1 = args[0];
        //BufferedReader fr= new BufferedReader(new InputStreamReader((new FileInputStream(fname1)),"CP1251"));
        BufferedReader fr = new BufferedReader(new InputStreamReader((new FileInputStream(fname1))));

        String[] s;

        while (fr.ready())
        {
            s = fr.readLine().split(" ");
            PEOPLE.add( parSer(s));
        }

  //      printL(PEOPLE);
        fr.close();

    }

//    public static void printL(List<Person> ll){
//
//        for(int i=0;i<ll.size();i++){
//            System.out.println(ll.get(i).getName()+" "+ll.get(i).getBirthday());
//        }
//
//    }


    public static Person parSer(String[] s){

        Date d=null;
        String name;

        if(s.length==6){
            d=crDate(s[3],s[4],s[5]);
        }
        if(s.length==5){
            d=crDate(s[2],s[3],s[4]);
        }
        if(s.length==4){
            d=crDate(s[1],s[2],s[3]);
        }

        return new Person(parsName(s),d);

    }

    private static Date crDate(String dd, String mm, String yyyy){

        SimpleDateFormat formatter = new SimpleDateFormat("dd MM yyyy");
        String dateInString = dd+" "+mm+" "+yyyy;
        Date date = null;
        try {
              date = formatter.parse(dateInString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    private static String parsName(String[] s){
        String name=null;
        if(s.length==6){
            name=s[0]+" "+s[1]+" "+s[2];
        }
        if(s.length==5){
            name=s[0]+" "+s[1];
        }
        if(s.length==4){
            name=s[0];
        }


        return name;
    }

}
