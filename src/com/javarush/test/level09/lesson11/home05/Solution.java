package com.javarush.test.level09.lesson11.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Гласные и согласные буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа должна вывести на экран две строки:
1. первая строка содержит только гласные буквы
2. вторая - только согласные буквы и знаки препинания из введённой строки.
Буквы соединять пробелом, каждая строка должна заканчиваться пробелом.

Пример ввода:
Мама мыла раму.
Пример вывода:
а а ы а а у
М м м л р м .
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String str = buff.readLine();
        //String str = "Мама мыла раму.";

        StringBuilder myGChar = new StringBuilder(1);
        StringBuilder mySChar = new StringBuilder(1);

        char[] myAllChar = str.toCharArray();
        for (int i = 0; i < myAllChar.length; i++)
        {
            if (myAllChar[i]=='\u0020'){
                continue;
            }
            if (isVowel(myAllChar[i]))
            {
                myGChar.append(String.valueOf(myAllChar[i]) + " ");
                //myGChar.append(" ");
            } else
            {
                mySChar.append(String.valueOf(myAllChar[i]) + " ");
                //mySChar.append(" ");
            }
        }

        System.out.println(myGChar);
        System.out.println(mySChar);

    }


    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    //метод проверяет, гласная ли буква
    public static boolean isVowel(char c)
    {
        c = Character.toLowerCase(c);  //приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   //ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}
