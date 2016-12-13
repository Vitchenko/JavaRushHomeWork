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



//7.1.	Параметризация метода. Замени методы incAverageGradeBy01() и incAverageGradeBy02()
//    одним методом incAverageGrade(double delta).

    public void incAverageGrade(double delta)
    {
        setAverageGrade(getAverageGrade() + delta);
    }


    public void setCourse(int value){
        course=value;
    }
    public void setAverageGrade(double value){
        averageGrade = value;
    }
    
//    7.4.	Замена параметров объектом. Перепиши методы setBeginningOfSession и setEndOfSession,
//    чтобы они вместо набора параметров принимали по одному объекту даты.

    public void setBeginningOfSession(Date date) {
        beginningOfSession = date;
    }

    public void setEndOfSession(Date date) {
        endOfSession = date;
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
