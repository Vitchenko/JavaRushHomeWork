package com.javarush.test.level34.lesson15.big01.controller;

import com.javarush.test.level34.lesson15.big01.view.View;
import com.javarush.test.level34.lesson15.big01.model.Model;


public class Controller
{
    private View view;
    private Model model;

    public Controller()
    {
        view=new View(this);
        model=new Model();
        view.init();
    }

    public static void main(String[] args)
    {
        new Controller();
    }
}
