package com.javarush.test.level29.lesson15.big01.human;


import java.util.Date;


public class Student extends UniversityPerson {
    private double averageGrade;

    private Date beginningOfSession;
    private Date endOfSession;
    private int course;

    public Student(String name, int age, double averageGrade) {
        super(name, age);
        this.name = name;
        this.age = age;
        this.averageGrade = averageGrade;
    }

    public void live() {
        learn();
    }

    public void learn() {
    }

    public int getCourse() {
        return course;
    }




    public void incAverageGradeBy01()
    {
        averageGrade += 0.1;
    }

    public void incAverageGradeBy02()
    {
        averageGrade += 0.2;
    }
//6.1.	Замена параметра набором специализированных методов. Замени метод setValue() класса
//    Student специализированными методами setCourse и setAverageGrade.

//    public void setValue(String name, double value) {
//        if (name.equals("averageGrade")) {
//            averageGrade = value;
//            return;
//        }
//        if (name.equals("course")) {
//            course = (int)value;
//            return;
//        }
//    }
    public void setCourse(int value){
        course=value;
    }
    public void setAverageGrade(double value){
        averageGrade = value;
    }
    
    public void setBeginningOfSession(int day, int month, int year) {
        beginningOfSession = new Date(year, month, day);
    }

    public void setEndOfSession(int day, int month, int year) {
        endOfSession = new Date(year, month, day);
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    @Override
    public String getPosition()
    {
        return "Студент";
    }
}
