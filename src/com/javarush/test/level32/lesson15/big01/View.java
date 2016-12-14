package com.javarush.test.level32.lesson15.big01;

import com.javarush.test.level32.lesson15.big01.listeners.FrameListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class View extends JFrame implements ActionListener
{

    private Controller controller;

    public Controller getController()
    {
        return controller;
    }

    private JTabbedPane tabbedPane=new JTabbedPane();
    private JTextPane htmlTextPane=new JTextPane();
    private JEditorPane plainTextPane=new JEditorPane();

    public void setController(Controller controller)
    {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

    }
/**4.3.	Реализуй метод init() представления. Он должен:
 4.3.1.	Вызывать инициализацию графического интерфейса initGui().
 4.3.2.	Добавлять слушателя событий нашего окна. В качестве подписчика создай и используй
 объект класса FrameListener. В качестве метода для добавления подписчика используй
 подходящий метод из класса Window от которого наследуется и наш класс через
 классы JFrame и Frame.
 4.3.3.	Показывать наше окно. Используй метод setVisible с правильным параметром.
 На этом этапе приложение при запуске должно показывать окно, которое можно растягивать,
 разворачивать, закрыть и т.д.*/

    public void init(){
        initGui();

        FrameListener frameListener = new FrameListener(this);
        addWindowListener(frameListener);
        //Показывать наше окно
        setVisible(true);
    }


    public void exit() {
      controller.exit();
    }

    public void initMenuBar(){

    }
    public void  initEditor(){

    }

    public void  initGui(){
        initMenuBar();
        initEditor();
        pack();
    }

}
