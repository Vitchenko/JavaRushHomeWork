package com.javarush.test.level32.lesson15.big01.actions;

import javax.swing.text.StyledEditorKit;
import java.awt.event.ActionEvent;

/**
 * Created by viv on 14.12.2016.
 */
public class SubscriptAction extends StyledEditorKit.StyledTextAction
{
    /**
     * Creates a new StyledTextAction from a string action name.
     *
     * @param nm the name of the action
     */
    public SubscriptAction(String nm)
    {
        super(nm);
    }



    @Override
    public void actionPerformed(ActionEvent e)
    {

    }
}
