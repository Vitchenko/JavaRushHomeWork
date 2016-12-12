package com.javarush.test.level29.lesson15.big01.human;

import java.util.Date;

public class University extends Student {

    public University(String name, int age, double averageGrade, String university, Date beginningOfSession, Date endOfSession)
    {
        super(name, age, averageGrade, university, beginningOfSession, endOfSession);
    }

    public Student getStudentWithAverageGrade() {
        //TODO:
        return null;
    }

    public Student getStudentWithMaxAverageGrade(double averageGrade) {
        //TODO:
        return null;
    }

    public void getStudentWithMinAverageGradeAndExpel() {
        //TODO:
    }
}
