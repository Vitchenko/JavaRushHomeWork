package com.javarush.test.level24.lesson14.big01;

/**
 Главному классу (Arcanoid) нужно будет хранить информацию о размерах поля, где будут происходить все действия.
 Поэтому:
 а) добавь ему две переменных width (ширина) типа int и height(высота) типа int
 б) добавь их в конструктор класса
 г) сделай для них геттеры и сеттеры
 */
public class Arcanoid
{
    int width;
    int height;

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public Arcanoid(int width, int height)
    {

        this.width = width;
        this.height = height;
    }

    public static void main(String[] args)
    {

    }
}
