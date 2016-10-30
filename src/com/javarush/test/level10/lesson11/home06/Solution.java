package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        //напишите тут ваши переменные и конструкторы
        String fName;
        String lName;
        String pozevnoi;
        int age;
        int growth;
        int weight;

        Human(){}
        Human(String fName){}
        Human(String fName, String lName){}
        Human(String fName, String lName, String pozevnoi){}
        Human(String fName, String lName, String pozevnoi, int age){}
        Human(String fName, String lName, String pozevnoi, int age, int growth){}
        Human(String fName, String lName, String pozevnoi, int age, int growth, int weight){}
        Human(String lName, String pozevnoi, int age, int growth, int weight){}
        Human(String pozevnoi, int age, int growth, int weight){}
        Human(int age, int growth, int weight){}
    }
}
