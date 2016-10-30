package com.javarush.test.level17.lesson10.home09;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все
строки, которые есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args)
    {
        BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
        String fname1= null;
        String fname2= null;
        try
        {
            fname1 = buff.readLine();
            fname2= buff.readLine();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        BufferedReader br1 = null;
        BufferedReader br2 = null;
        try {

            String sCurrentLine;

            br1 = new BufferedReader(new FileReader(fname1));
            br2 = new BufferedReader(new FileReader(fname2));


            while ((sCurrentLine = br1.readLine()) != null) {
                allLines.add(sCurrentLine);
            }
            while ((sCurrentLine = br2.readLine()) != null) {
                forRemoveLines.add(sCurrentLine);
            }

            Solution sl=new Solution();
            sl.joinData();


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br1 != null)br1.close();
                if (br2 != null)br2.close();
                if (buff != null)buff.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }



    }

    public void joinData () throws CorruptedDataException
    {

        if (allLines.containsAll(forRemoveLines))
        {
            for (int i = 0; i < forRemoveLines.size(); i++)
            {
                allLines.remove(forRemoveLines.get(i));
            }
        } else
        {
            allLines.clear();
            throw new CorruptedDataException();
        }


        System.out.println(allLines.toString());
        System.out.println(forRemoveLines.toString());
    }

}
