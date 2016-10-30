package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
            String f1=reader.readLine();
            String f2=reader.readLine();
            String f3=reader.readLine();

            FileInputStream inputStream = new FileInputStream(f1);
            // Создаем поток-записи-байт-в-файл
            FileOutputStream outputStream2 = new FileOutputStream(f2);
            FileOutputStream outputStream3 = new FileOutputStream(f3);

            int fsize=inputStream.available();
            int fsize2;
            int fsize3;

            if (fsize%2==0){
                fsize2=fsize/2;
                fsize3=fsize/2;
            }else{
                fsize2=fsize/2+1;
                fsize3=fsize/2;
            }

            byte[] buffer2 = new byte[fsize2];
            byte[] buffer3 = new byte[fsize3];
            while (inputStream.available() > 0) //пока есть еще непрочитанные байты
            {
                // прочитать очередной блок байт в переменную buffer и реальное количество в count
                int count = inputStream.read(buffer2);
                outputStream2.write(buffer2, 0, count); //записать блок(часть блока) во второй поток
                int count2 = inputStream.read(buffer3);
                outputStream3.write(buffer3, 0, count2); //записать блок(часть блока) во второй поток

            }

            reader.close();
            inputStream.close(); //закрываем оба потока. Они больше не нужны.
            outputStream2.close();
            outputStream3.close();

    }
}
