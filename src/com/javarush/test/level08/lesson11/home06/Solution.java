package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Human ded1 = new Human();
        Human ded2 = new Human();
        Human bab1 = new Human();
        Human bab2 = new Human();

        Human fath = new Human();
        Human moth = new Human();
        Human baby1 = new Human();
        Human baby2 = new Human();
        Human baby3 = new Human();

        ded1.name="ded1";
        ded1.sex=true;
        ded1.age=78;
        ded1.children.add(fath);

        ded2.name="ded2";
        ded2.sex=true;
        ded2.age=75;
        ded2.children.add(moth);

        bab1.name="bab1";
        bab1.sex=false;
        bab1.age=70;
        bab1.children.add(fath);

        bab2.name="bab2";
        bab2.sex=false;
        bab2.age=71;
        bab2.children.add(moth);

        fath.name="fath";
        fath.sex=true;
        fath.age=45;
        fath.children.add(baby1);
        fath.children.add(baby2);
        fath.children.add(baby3);

        moth.name="moth";
        moth.sex=false;
        moth.age=40;
        moth.children.add(baby1);
        moth.children.add(baby2);
        moth.children.add(baby3);

        baby1.name="baby1";
        baby1.sex=false;
        baby1.age=10;

        baby2.name="baby2";
        baby2.sex=true;
        baby2.age=8;

        baby3.name="baby3";
        baby3.sex=true;
        baby3.age=6;

        System.out.println(ded1.toString());
        System.out.println(ded2.toString());
        System.out.println(bab1.toString());
        System.out.println(bab2.toString());

        System.out.println(fath.toString());
        System.out.println(moth.toString());
        System.out.println(baby1.toString());
        System.out.println(baby2.toString());
        System.out.println(baby3.toString());


    }

    public static class Human
    {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children=new ArrayList<>();

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
