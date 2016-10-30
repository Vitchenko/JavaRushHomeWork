package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        String fname1 = args[0];
        String fname2 = args[1];

        BufferedReader fr = new BufferedReader(new InputStreamReader((new FileInputStream(fname1))));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter((new FileOutputStream(fname2))));

        String[] arr=null;


        while (fr.ready())
        {
            arr = fr.readLine().split(" ");
            for(int i=0;i<arr.length;i++){
                if(arr[i].matches(".*\\d.*")==true){
                    wr.write(arr[i]+" ");
                    wr.flush();
                }
            }
        }

        fr.close();
        wr.close();

    }




}
