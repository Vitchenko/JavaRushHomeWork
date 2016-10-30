package com.javarush.test.level25.lesson16.big01;

/**
 Теперь займемся классом Canvas.
 Он у нас будет содержать матрицу, куда мы будем рисовать.
 У матрицы есть ширина и высота.
 А еще будем в ней хранить не числа(int), а символы (char).
 Надо:
 а) Добавить в класс две переменные width и height
 б) Добавить в класс переменную matrix (char[][])
 в) Добавь геттеры для них
 г) В конструкторе проинициализируй матрицу
 */

public class Canvas
{
    int width, height;
    char[][] matrix;

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public char[][] getMatrix()
    {
        return matrix;
    }

    public Canvas(int width, int height)
    {
        this.width = width;
        this.height = height;
        this.matrix = new char[height + 2][width + 2];
    }
}
