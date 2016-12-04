package com.javarush.test.level22.lesson13.task01;

import java.util.ArrayList;
import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {

    public static void main(String[] args)
    {
        String[] strarr=getTokens("level22.lesson13.task01", ".");
        for(String s:strarr){
            System.out.println(s);
        }
    }

    public static String [] getTokens(String query, String delimiter) {


        ArrayList<String> arr=new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(query,delimiter);

        while (tokenizer.hasMoreTokens())
        {
            String token = tokenizer.nextToken();
            arr.add(token);
        }

        String[] arrStr=new String[arr.size()];

        for(int i=0;i<arrStr.length;i++){
            arrStr[i]=arr.get(i);
        }

        return arrStr;
    }
}
