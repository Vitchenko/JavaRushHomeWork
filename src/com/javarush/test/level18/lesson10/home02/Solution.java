package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Solution {

        public static void main(String[] args) throws IOException
        {
            String fname=args[0];
            double bukv=0.0;
            double prob=0.0;
            double vse=0.0;

            FileInputStream fs=new FileInputStream(fname);

            try
            {
                byte[] buf=new byte[fs.available()];
                bukv=fs.available();

                while(fs.available()>0){
                    int count=fs.read(buf);
                }

                for(int i=0;i<buf.length;i++){

                    if ((char)buf[i]==32 ){
                        prob++;
                    }
                }
                double templateDouble=prob/bukv*100;

                double newDouble = new BigDecimal(templateDouble).setScale(2, RoundingMode.HALF_EVEN).doubleValue();

                System.out.println(newDouble);

            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            finally
            {
                fs.close();
            }
        }

}

