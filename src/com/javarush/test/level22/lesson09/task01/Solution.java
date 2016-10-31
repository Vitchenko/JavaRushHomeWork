package com.javarush.test.level22.lesson09.task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fname=br.readLine();
        br.close();

        //String fname="d:/1.txt";

        BufferedReader fr = new BufferedReader(new FileReader(fname));
        String[] strLines=null;
        ArrayList<String> arrStr = new ArrayList<>();

        while (fr.ready())
        {
            strLines = fr.readLine().split(" ");
            for (int i = 0; i < strLines.length; i++)
            {
                arrStr.add(strLines[i]);
            }
        }

//        for(String s: arrStr){
//            System.out.println(s);
//        }
//        System.out.println("----------");

        for (int i=0;i<arrStr.size();i++){
            StringBuilder sb=new StringBuilder(arrStr.get(i));

            ArrayList<String> arrStr2 = new ArrayList<>(arrStr);
            arrStr2.remove(arrStr.get(i));

            int ff=arrStr2.indexOf(sb.reverse().toString());
                if(ff>-1){
                    Pair pp=new Pair();
                    pp.first=sb.toString();
                    pp.second=sb.reverse().toString();
                    result.add(pp);
                    arrStr.remove(sb.toString());
                    arrStr.remove(sb.reverse().toString());
                }
            }


        for(Pair s:result){
            System.out.println(s);
        }

        fr.close();

    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
