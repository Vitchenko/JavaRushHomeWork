package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String strF= buff.readLine();
        ArrayList<Integer> arr=new ArrayList<>();

        BufferedReader br = null;

        try {

            String sCurrentLine;

            br = new BufferedReader(new FileReader(strF));

            while ((sCurrentLine = br.readLine()) != null) {

                if((Integer.parseInt(sCurrentLine))%2==0){
                    arr.add(Integer.parseInt(sCurrentLine));

                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        int tmp;
        for (int i=arr.size()-1;i>0;i--){
            for (int j=0; j<i; j++){
                if (arr.get(j)>arr.get(j+1)){
                    tmp=arr.get(j);
                    arr.set(j,arr.get(j+1));
                    arr.set(j+1,tmp);
                }
            }
        }

        for (int i=0;i<arr.size();i++){
            System.out.println(arr.get(i));
        }

    }
}
