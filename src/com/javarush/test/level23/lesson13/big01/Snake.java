package com.javarush.test.level23.lesson13.big01;

import java.util.ArrayList;

/**
 Надо:
 а) Передать в конструктор координаты головы змеи (x и y)
 б) создать в нем первый "кусочек змеи" (голову) и добавить его в коллекцию sections.
 в) isAlive выставить в true
 г) не забудь в конструкторе инициализировать переменную sections. В null не много-то и добавишь!
 д) создать и реализовать метод int getX(). Метод должен вернуть координату Х головы змеи.
 е) создать и реализовать метод int getY(). Метод должен вернуть координату Y головы змеи.
 ё) еще добавить классу метод move()- он нам пригодится попозже.

 */
public class Snake
{
    ArrayList<SnakeSection> sections=new ArrayList<>();
    boolean isAlive;
    SnakeDirection direction;

    public ArrayList<SnakeSection> getSections()
    {
        return sections;
    }

    public boolean isAlive()
    {
        return isAlive;
    }

    public SnakeDirection getDirection()
    {
        return direction;
    }
    public void setDirection(SnakeDirection direction)
    {
        this.direction = direction;
    }

    public Snake(int x, int y){
        SnakeSection sc=new SnakeSection(x,y);
        sections.add(sc);
        this.isAlive=true;
    }

    public int getX(){
        return sections.get(0).getX();
    }
    public int getY(){
        return sections.get(0).getY();
    }

    public void move(){

    }
}
