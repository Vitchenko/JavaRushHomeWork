package com.javarush.test.level29.lesson15.big01.human;

public class Worker {
    private Human human;
    private double salary;
    public String company;

    public Worker(Human human, double salary, String company)
    {
        this.human = human;
        this.salary = salary;
        this.company = company;
    }

    public void live() {
        human.live();

    }

    public double getSalary() {
        return salary;
    }

    public void setSlr(double salary) {
        this.salary = salary;
    }
}
