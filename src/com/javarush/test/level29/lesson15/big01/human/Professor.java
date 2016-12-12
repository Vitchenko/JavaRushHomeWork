package com.javarush.test.level29.lesson15.big01.human;

public class Professor extends Teacher {
    public Professor(String name, int age, int numberOfStudents, String university)
    {
        super(name, age, numberOfStudents, university);
    }

    public void live() {
        teach();
    }

}
