package com.javarush.test.level34.lesson15.big01.view;

import com.javarush.test.level34.lesson15.big01.model.Player;
import com.javarush.test.level34.lesson15.big01.model.Box;

import javax.swing.*;
import java.awt.*;

/**
 * Created by viv on 19.12.2016.
 */
public class Field extends JPanel
{
    private View view;

    public Field(View view)
    {
        this.view = view;
    }

    public void paint(Graphics g){
        Player player=new Player(30,30);
        player.draw(g);

        Box box=new Box(50,50);
        box.draw(g);
    }
}
