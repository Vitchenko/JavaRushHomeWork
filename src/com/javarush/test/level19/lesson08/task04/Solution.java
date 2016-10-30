package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream defaultPrintStream = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream newPrintStream = new PrintStream(byteArrayOutputStream);
        System.setOut(newPrintStream);
        testString.printSomething();
        System.setOut(defaultPrintStream);

        String[] s;
        String result = byteArrayOutputStream.toString();
        s=result.split(" ");
        String rez=null;

        if (s[1].equals("+")){
            int r=Integer.parseInt(s[0])+Integer.parseInt(s[2]);
            rez=s[0]+" "+s[1]+" "+ s[2]+" "+ s[3]+" "  +r;
        }
        if (s[1].equals("-")){
            int r=Integer.parseInt(s[0])-Integer.parseInt(s[2]);
            rez=s[0]+" "+s[1]+" "+ s[2]+" "+ s[3]+" "  +r;
        }
        if (s[1].equals("*")){
            int r=Integer.parseInt(s[0])*Integer.parseInt(s[2]);
            rez=s[0]+" "+s[1]+" "+ s[2]+" "+ s[3]+" "  +r;
        }

        System.out.print(rez);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");

        }
    }
}

