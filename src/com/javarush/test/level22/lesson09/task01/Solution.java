package com.javarush.test.level22.lesson09.task01;

import java.io.*;
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
        BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
        //String fname=buff.readLine();
        String fname="d:/1.txt";
        buff.close();

        String[] arrstr=null;
        ArrayList<StringBuilder> arrSb=new ArrayList<>();
        BufferedReader bf=new BufferedReader(new FileReader(fname));

        while(bf.ready()){
            arrstr = bf.readLine().split(" ");
            for(int i=0;i<arrstr.length;i++){
                StringBuilder sb=new StringBuilder();
                arrSb.add(sb.append(arrstr[i]));
            }
        }
        bf.close();

        for(int i=0;i<arrSb.size();i++){
            System.out.println(arrSb.get(i));

        }




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
