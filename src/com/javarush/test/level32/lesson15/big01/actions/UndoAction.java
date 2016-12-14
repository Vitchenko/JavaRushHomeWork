package com.javarush.test.level32.lesson15.big01.actions;

import javax.swing.*;

import java.awt.event.ActionEvent;
import com.javarush.test.level32.lesson15.big01.View;

public class UndoAction extends AbstractAction
{
    private View view;

    public UndoAction(View view)
    {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        view.undo();
    }
}
