package com.javarush.test.level22.lesson18.big01;

/**
 Теперь перейдем к классу Field.
 Он будет отвечать за хранение данных о текущих занятых и свободных клетках на поле игры.
 Добавь в класс Field два поля поля: width (ширина) типа int, height(высота) типа int.
 Так же нам понадобится матрица - двумерный массив: matrix(матрица) типа int[][];
 Там же добавь getter'ы для созданных переменных.
 Добавь конструктор с двумя параметрами width и height. И не забудь про матрицу.

 ВАЖНО!
 Двумерный массив можно представить как массив массивов или как прямоугольную матрицу.
 При этом первой координатой в массиве у нас будет номер строки, а второй - столбца.
 Другими словами ячейка с координатами x, y - это matrix[y][x].
------------




 */
public class Field
{
    int width;
    int height;
    int[][] matrix;

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

    public int[][] getMatrix()
    {
        return matrix;
    }

    public void setMatrix(int[][] matrix)
    {
        this.matrix = matrix;
    }

    public Field(int width, int height, int[][] matrix)
    {
        this.width = width;
        this.height = height;
        this.matrix = matrix;
    }

    public void print(){

    }

    public void removeFullLines(){

    }

    public Integer getValue(int x, int y){
        if (x >= 0 && x < width && y >= 0 && y < height){
            return (Integer) matrix[y][x];
        }
        return null;
    }

    public void setValue(int x, int y, int value){
        if (x >= 0 && x < width && y >= 0 && y < height){
            matrix[y][x]=value;
        }
    }
}
