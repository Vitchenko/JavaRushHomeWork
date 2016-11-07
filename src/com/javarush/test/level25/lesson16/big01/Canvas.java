package com.javarush.test.level25.lesson16.big01;

/**


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


public void setPoint(double x, double y, char c){
        int x0 = (int) Math.round(x);
        int y0 = (int) Math.round(y);
        if (y0 < 0 || y0 >= matrix.length) return;
        if (x0 < 0 || x0 >= matrix[y0].length) return;

        matrix[y0][x0] = c;
    }

    public void drawMatrix(double x, double y, int[][] matrix, char c){
        int height = matrix.length;
        int width = matrix[0].length;

        for (int i = 0; i < height; i++)
        {
            for (int j = 0; j < width; j++)
            {
                if (matrix[i][j] != 0)
                    setPoint(x + j, y + i, c);
            }
        }
    }

    public void clear(){
        int height = matrix.length;
        int width = matrix[0].length;

        for (int i = 0; i < height; i++)
        {
            for (int j = 0; j < width; j++)
            {
                matrix[i][j] = 32;

            }
        }
    }
    public void print(){
           for (int i = 0; i < height + 2; i++)
            {
                for (int j = 0; j < width + 2; j++)
                {
                    System.out.print(matrix[i][j]);
                }

                System.out.print("/n");
            }

            System.out.println();
            System.out.println();
    }


}
