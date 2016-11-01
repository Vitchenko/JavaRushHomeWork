package com.javarush.test.level22.lesson18.big01;

/**
 Задание 13
 Теперь приступим к реализации созданных методов.
 Напиши реализацию метода print в классе Field
 а) Метод должен выводить на экран прямоугольник.
 б) Высота прямоугольника равна height, ширина - width
 в) Если данная клетка пустая - вывести точку, если не пустая - английский X

 Подсказка:
 if (matrix[y][x]==0) ...
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
        for(int y=0;y<height;y++){
            for(int x=0;x<width;x++){
                if (matrix[y][x]==0) {
                    if (x==width-1){
                    System.out.print(".\n");}
                    else{
                        System.out.print(".");
                    }
                }
                else{
                    if (x==width-1){
                    System.out.print("X\n");}
                    else{
                        System.out.print("X");
                    }
                }

            }
        }
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
