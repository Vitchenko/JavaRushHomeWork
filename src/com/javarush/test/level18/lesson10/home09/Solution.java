package com.javarush.test.level18.lesson10.home09;

/* Файлы и исключения
Читайте с консоли имена файлов
Если файла не существует (передано неправильное имя файла), то
перехватить исключение FileNotFoundException, вывести в консоль переданное неправильное имя файла и
завершить работу программы.
Закрыть потоки. Не использовать try-with-resources
Не используйте System.exit();
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        String fname=null;
        FileInputStream fs=null;

        BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
        while(true){
            fname=buff.readLine();
            try {
                fs=new FileInputStream(fname);
            }catch (FileNotFoundException e) {
                System.out.println(fname);
                if (buff != null)buff.close();
                if (fs != null)fs.close();
                break;
            } finally {

            }

        }


    }
}
