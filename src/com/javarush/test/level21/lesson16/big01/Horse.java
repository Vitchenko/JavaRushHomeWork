package com.javarush.test.level21.lesson16.big01;

public class Horse
{
    private String name;
    private double speed;
    private double distance;

    public Horse(String name, double speed, double distance)
    {
        this.setName(name);
        this.setSpeed(speed);
        this.setDistance(distance);
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getSpeed()
    {
        return speed;
    }

    public void setSpeed(double speed)
    {
        this.speed = speed;
    }

    public double getDistance()
    {
        return distance;
    }

    public void setDistance(double distance)
    {
        this.distance = distance;
    }


    public void move(){
        speed *= Math.random();
        distance += speed;
    }
//    Задание 13
//    Теперь вернемся к методу print класса Horse.
//    Т.к. мы работаем с консолью, то все лошади на бегах будут выглядеть примерно так:
//        ........Sleven                       <- лошадь Слевин
//....Lucky                            <- лошадь Лаки
//..........Gomer                      <- лошадь Гомер
//
//    Другими словами, в методе print надо вывести на экран строку состоящую из точек и имени лошади.
//    Количество точек равно distance, округленному до целого числа.




    public void print(){
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<Math.ceil(getDistance());i++){
            sb.append(".");
        }
        System.out.println(sb+getName());
    }



}
