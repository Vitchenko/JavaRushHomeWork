package com.javarush.test.level34.lesson15.big01.view;

import com.javarush.test.level34.lesson15.big01.controller.EventListener;
import com.javarush.test.level34.lesson15.big01.model.GameObject;
import com.javarush.test.level34.lesson15.big01.model.Home;
import com.javarush.test.level34.lesson15.big01.model.Player;
import com.javarush.test.level34.lesson15.big01.model.Box;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.util.Set;

/**
 * Created by viv on 19.12.2016.
 */
public class Field extends JPanel {

    private View view;
    private EventListener eventListener;

    public Field(View view) {
        this.view = view;
//        this.addKeyListener(new KeyHandler());
        this.setFocusable(true);
    }

    public void paint(Graphics g) {

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 500, 500);

        Set<GameObject> gameObjectSet = view.getGameObjects().getAll();

        for (GameObject gameObject : gameObjectSet) {
            gameObject.draw(g);
        }

    }

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    /**Добавим немного интерактивности в нашу игру (перемещение игрока с помощью
     клавиатуры). Начнем с обработки нажатия клавиш клавиатуры.
     14.1.	Добавь в класс Field вложенный класс KeyHandler унаследованный от
     KeyAdapter.
     14.2.	Перегрузи у него метод keyPressed(). Если была нажата клавиша с кодом
     VK_LEFT, то пошли eventListener-у событие move с параметром Direction.LEFT.
     Аналогичным образом обработай нажатия клавиш с кодом VK_RIGHT, VK_UP и
     VK_DOWN. Если пользователь нажал клавишу R с кодом VK_R, то вызови у слушателя
     событий метод restart().
     14.3.	В конструкторе класса Field:
     14.3.1.	Создай объект класса KeyHandler.
     14.3.2.	Установи его слушателем с помощью метода addKeyListener().
     14.3.3.	Установи focusable в true (метод setFocusable()).*/

    public class KeyHandler extends KeyAdapter
    {

    }



}
