package com.javarush.test.level24.lesson14.big01;

/**
 Задание 10
 Что мы будем делать с Canvas?
 Мы будем рисовать на нем (в его матрице).
 Поэтому нам понадобятся два метода
 public void setPoint(double x, double y, char c)
 public void drawMatrix(double x, double y, int[][] matrix, char c)

 Первый метод - setPoint будет "ставить точку в координатах x,y цветом c".
 В методе надо:
 а) округлить x и y до целых чисел
 б) занести в matrix[y][x] значение с
 в) ничего не делать, если x<0 или y<0 или y>matrix.length или x>matrix[0].length

 Второй метод - drawMatrix копирует переданную ему картинку (матрицу) в матрицу Canvas.
 И не просто копирует, а начиная с координат x, y
 В методе надо:
 а) с помощью двух вложенных циклов пройтись по всем ячейкам переданной картинки
 б) если значение ячейки matrix[i][j] не равно 0, то покрасить в матрице объекта Canvas точку (x+j, y+i) в цвет c:
 setPoint(x+j, y+i, c)
 */
public class Canvas
{
    int width,height;

    public Canvas(int width, int height)
    {
        this.width = width;
        this.height = height;
    }

    char[][] matrix;

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

    public char[][] getMatrix()
    {
        return matrix;
    }

    public void setMatrix(char[][] matrix)
    {
        this.matrix = matrix;
    }

    /**
     *  Первый метод - setPoint будет "ставить точку в координатах x,y цветом c".
     В методе надо:
     а) округлить x и y до целых чисел
     б) занести в matrix[y][x] значение с
     в) ничего не делать, если x<0 или y<0 или y>matrix.length или x>matrix[0].length*/

    public void setPoint(double x, double y, char c){
        int xx=(int)x;
        int yy=(int)y;

    }
    public void drawMatrix(double x, double y, int[][] matrix, char c){

    }
}
