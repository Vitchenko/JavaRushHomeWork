package com.javarush.test.level11.lesson08.task01;

/* Все скрыто
Скрыть все внутренние переменные класса Cat.
*/

public class Solution
{
    public static void main(String[] args)
    {
    }

    public class Cat
    {
        private String name;
        private int age;
        private int weight;

        public Cat()
        {
        }

        public Cat(String name, int age, int weight)
        {
            this.setName(name);
            this.setAge(age);
            this.setWeight(weight);
        }

        public String getName()
        {
            return name;
        }

        public void setName(String name)
        {
            this.name = name;
        }

        public int getAge()
        {
            return age;
        }

        public void setAge(int age)
        {
            this.age = age;
        }

        public int getWeight()
        {
            return weight;
        }

        public void setWeight(int weight)
        {
            this.weight = weight;
        }
    }
}
