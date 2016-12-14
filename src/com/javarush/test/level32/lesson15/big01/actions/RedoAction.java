package com.javarush.test.level32.lesson15.big01.actions;

import javax.swing.*;

import java.awt.event.ActionEvent;
import com.javarush.test.level32.lesson15.big01.View;

/**
 * Created by viv on 14.12.2016.
 */
public class RedoAction extends AbstractAction
{

    private View view;

    public RedoAction(View view)
    {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

    }
}
