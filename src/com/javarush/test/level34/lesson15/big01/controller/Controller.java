package com.javarush.test.level34.lesson15.big01.controller;

import com.javarush.test.level34.lesson15.big01.model.Direction;
import com.javarush.test.level34.lesson15.big01.model.GameObjects;
import com.javarush.test.level34.lesson15.big01.view.View;
import com.javarush.test.level34.lesson15.big01.model.Model;


public class Controller implements EventListener
{
    private View view;
    private Model model;

    public Controller()
    {

        model = new Model();
        model.restart();
        model.setEventListener(this);
        view = new View(this);
        view.init();
        view.setEventListener(this);

    }

    public static void main(String[] args)
    {
        new Controller();
    }

    public void move(Direction direction)
    {
        model.move(direction);
        view.update();
    }


    public void restart() {
        model.restart();
        view.update();
    }


    public void startNextLevel() {
        model.startNextLevel();
        view.update();
    }



    public void levelCompleted(int level)
    {
       view.completed(level);
    }

    public GameObjects getGameObjects() {
        return model.getGameObjects();
    }

}
