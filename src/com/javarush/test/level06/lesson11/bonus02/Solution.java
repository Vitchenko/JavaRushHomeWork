package com.javarush.test.level06.lesson11.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Нужно добавить в программу новую функциональность
Задача: У каждой кошки есть имя и кошка-мама. Создать класс, который бы описывал данную ситуацию. Создать два объекта: кошку-дочь и
кошку-маму. Вывести их на экран.
Новая задача: У каждой кошки есть имя, кошка-папа и кошка-мама. Изменить класс Cat так, чтобы он мог описать данную ситуацию.
Создать 6 объектов: дедушку(папин папа), бабушку(мамина мама), папу, маму, сына, дочь.
Вывести их всех на экран в порядке: дедушка, бабушка, папа, мама, сын, дочь.

Пример ввода:
дедушка Вася
бабушка Мурка
папа Котофей
мама Василиса
сын Мурчик
дочь Пушинка

Пример вывода:
Cat name is дедушка Вася, no mother, no father +
Cat name is бабушка Мурка, no mother, no father +
Cat name is папа Котофей, no mother, father is дедушка Вася
Cat name is мама Василиса, mother is бабушка Мурка, no father
Cat name is сын Мурчик, mother is мама Василиса, father is папа Котофей
Cat name is дочь Пушинка, mother is мама Василиса, father is папа Котофей
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String grandFatherName = reader.readLine();
        //String grandFatherName="дедушка Вася";
        Cat catGrandFather = new Cat(grandFatherName);

        String grandMotherName = reader.readLine();
        //String grandMotherName="бабушка Мурка";
        Cat catGrandMother = new Cat(grandMotherName);

        String fatherName = reader.readLine();
        //String fatherName="папа Котофей";
        Cat catFather= new Cat(fatherName, catGrandFather, null);
        String motherName = reader.readLine();
        //String motherName="мама Василиса";
        Cat catMother = new Cat(motherName, null, catGrandMother);

        String sonName = reader.readLine();
        //String sonName="сын Мурчик";
        Cat catSon = new Cat(sonName,catFather, catMother);
        String doutherName = reader.readLine();
        //String doutherName="дочь Пушинка";
        Cat catDouther = new Cat(doutherName,catFather,catMother);

        System.out.println(catGrandFather);
        System.out.println(catGrandMother);

        System.out.println(catFather);
        System.out.println(catMother);

        System.out.println(catSon);
        System.out.println(catDouther);


    }

    public static class Cat
    {
        private String name;
        private Cat mParent;
        private Cat pParent;

        Cat(String name)
        {
            this.name = name;
        }


        Cat(String name, Cat pParent,Cat mParent)
        {
            this.name = name;
            this.mParent = mParent;
            this.pParent = pParent;
        }


        @Override
        public String toString()
        {

            if (mParent == null && pParent == null) return "Cat name is " + name + ", no mother, no father";
            if (pParent == null) return "Cat name is " + name + ", mother is " + mParent.name +", no father";
            if (mParent == null) return "Cat name is " + name + ", no mother, father is " + pParent.name;
            if (mParent != null && pParent != null)
                return "Cat name is " + name + ", mother is " + mParent.name + ", father is " + pParent.name;
            return null;
        }
    }

}
