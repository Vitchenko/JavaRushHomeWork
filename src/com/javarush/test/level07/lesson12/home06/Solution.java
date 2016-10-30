package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так,
чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Human ded = new Human("Иван",true,75,null,null);
        Human bab = new Human("Мария",false,72,null,null);

        Human ded1 = new Human("Иван1",true,70,null,null);
        Human bab1 = new Human("Мария1",false,68,null,null);

        Human pap = new Human("Яков",true,50,ded,bab);
        Human mam = new Human("Марта",false,45,ded1,bab1);

        Human son = new Human("Игорь",true,10,pap,mam);
        Human son2 = new Human("Виталик",true,15,pap,mam);
        Human dot = new Human("Света",false,5,pap,mam);

        System.out.println(ded.toString());
        System.out.println(bab.toString());
        System.out.println(ded1.toString());
        System.out.println(bab1.toString());
        System.out.println(pap.toString());
        System.out.println(mam.toString());
        System.out.println(son.toString());
        System.out.println(son2.toString());
        System.out.println(dot.toString());


    }

    public static class Human
    {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        Human(String name, boolean sex, int age, Human father, Human mother){
            this.name=name;
            this.sex=sex;
            this.age=age;
            this.father=father;
            this.mother=mother;

        }


        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
