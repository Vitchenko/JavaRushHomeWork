package com.javarush.test.level10.lesson11.home09;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* Одинаковые слова в списке
Ввести с клавиатуры в список 20 слов. Нужно подсчитать количество одинаковых слов в списке.
Результат нужно представить в виде словаря Map<String, Integer>, где первый параметр – уникальная строка,
а второй – число, сколько раз данная строка встречалась в списке.
Вывести содержимое словаря на экран.
В тестах регистр (большая/маленькая буква) влияет на результат.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> words = new ArrayList<String>();
        for (int i = 0; i < 20; i++)
        {
            words.add(reader.readLine());
        }

//        words.add("Слово1");
//        words.add("слово1");
//        words.add("Слово2");
//        words.add("слово1");
//        words.add("Слово1");
//        words.add("слово4");
//        words.add("Слово4");
//        words.add("слово4");
//        words.add("Слово5");
//        words.add("слово5");
//        words.add("Слово1");
//        words.add("слово1");
//        words.add("Слово2");
//        words.add("слово3");
//        words.add("Слово4");
//        words.add("слово5");
//        words.add("Слово4");
//        words.add("слово4");
//        words.add("Слово5");
//        words.add("слово5");

        Map<String, Integer> map = countWords(words);

        for (Map.Entry<String, Integer> pair : map.entrySet())
        {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }

        reader.close();
    }

    public static Map<String, Integer> countWords(ArrayList<String> list)
    {
        HashMap<String, Integer> result = new HashMap<String, Integer>();

        //напишите тут ваш код

        for (int i=0;i<list.size();i++){
            int count = Collections.frequency(list, list.get(i));
            result.put(list.get(i),count);

        }

        return result;
    }

}

