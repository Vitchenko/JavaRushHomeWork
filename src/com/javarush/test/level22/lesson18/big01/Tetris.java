package com.javarush.test.level22.lesson18.big01;

import java.awt.event.KeyEvent;

/**
 * Created by viv on 26.10.2016.
 */
public class Tetris extends Thread
{
    private Field field;
    private Figure figure;
    public static Tetris game;
    private boolean isGameOver;         //Игра Окончена?

    public static void main(String[] args)
    {
        game = new Tetris();
        game.run();

//        int[][] matrix=new int[10][8];
//        matrix[3][4]=1;
//        matrix[4][4]=1;
//        Field fl=new Field(8,10,matrix);
//        fl.print();
    }


    public Field getField()
    {
        return field;
    }

    public Figure getFigure()
    {
        return figure;
    }

    public void run(){

        //Создаем объект "наблюдатель за клавиатурой" и стартуем его.
        KeyboardObserver keyboardObserver = new KeyboardObserver();
        keyboardObserver.start();

        //выставляем начальное значение переменной "игра окончена" в ЛОЖЬ
        isGameOver = false;
        //создаем первую фигурку посередине сверху: x - половина ширины, y - 0.
        figure = FigureFactory.createRandomFigure(field.getWidth() / 2, 0);

        //пока игра не окончена
        while (!isGameOver)
        {
            //"наблюдатель" содержит события о нажатии клавиш?
            if (keyboardObserver.hasKeyEvents())
            {
                //получить самое первое событие из очереди
                KeyEvent event = keyboardObserver.getEventFromTop();
                //Если равно символу 'q' - выйти из игры.
                if (event.getKeyChar() == 'q') return;
                //Если "стрелка влево" - сдвинуть фигурку влево
                if (event.getKeyCode() == KeyEvent.VK_LEFT)
                    figure.left();
                    //Если "стрелка вправо" - сдвинуть фигурку вправо
                else if (event.getKeyCode() ==  KeyEvent.VK_RIGHT)
                    figure.right();
                    //Если  код клавишы равен 12 ("цифра 5 на доп. клавиатуре") - повернуть фигурку
                else if (event.getKeyCode() ==  12)
                    figure.rotate();
                    //Если "пробел" - фигурка падает вниз на максимум
                else if (event.getKeyCode() ==  KeyEvent.VK_SPACE)
                    figure.downMaximum();
            }

            step();             //делаем очередной шаг
            field.print();      //печатаем состояние "поля"
            try
            {
                Thread.sleep(300);  //пауза 300 миллисекунд - 1/3 секунды
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

        //Выводим сообщение "Game Over"
        System.out.println("Game Over");

    }

    public void step(){

    }



}
