package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/



import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        String fname=args[0];
        FileInputStream inputStream = new FileInputStream(fname);

        byte[] buffer = new byte[inputStream.available()];
        while (inputStream.available() > 0) //пока есть еще непрочитанные байты
        {
            int count = inputStream.read(buffer);
        }

        ArrayList<Byte> arr=new ArrayList<>();
        for (int i=0;i<buffer.length;i++){
            arr.add(buffer[i]);
        }

        for (byte i=0; i<127 ;i++){
            int cnt = Collections.frequency(arr,i);
            if (cnt!=0)
            {
                System.out.println((char) i + " " + cnt);
            }
        }
        inputStream.close(); //закрываем оба потока. Они больше не нужны.
    }
}
