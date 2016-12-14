package com.javarush.test.level32.lesson15.big01;

import com.javarush.test.level32.lesson15.big01.listeners.FrameListener;
import com.javarush.test.level32.lesson15.big01.listeners.TabbedPaneChangeListener;

import javax.swing.*;
import java.awt.*;
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

    //constructor
    public View() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (IllegalAccessException e) {
            ExceptionHandler.log(e);
        } catch (InstantiationException e) {
            ExceptionHandler.log(e);
        } catch (UnsupportedLookAndFeelException e) {
            ExceptionHandler.log(e);
        } catch (ClassNotFoundException e) {
            ExceptionHandler.log(e);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {

    }

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
        //Создавать новый объект типа JMenuBar. Это и будет наша панель меню
        JMenuBar jMenuBar = new JMenuBar();
        //С помощью MenuHelper инициализировать меню
        MenuHelper.initFileMenu(this, jMenuBar);
        MenuHelper.initEditMenu(this, jMenuBar);
        MenuHelper.initStyleMenu(this, jMenuBar);
        MenuHelper.initAlignMenu(this, jMenuBar);
        MenuHelper.initColorMenu(this, jMenuBar);
        MenuHelper.initFontMenu(this, jMenuBar);
        MenuHelper.initHelpMenu(this, jMenuBar);

        //Добавлять в верхнюю часть панели контента текущего фрейма нашу панель меню, аналогично тому,
        // как это мы делали с панелью вкладок
        getContentPane().add(jMenuBar, BorderLayout.NORTH);
    }

    public void  initEditor(){
        //Устанавливать значение "text/html" в качестве типа контента для компонента htmlTextPane
        htmlTextPane.setContentType("text/html");

        //Создавать новый локальный компонент JScrollPane на базе htmlTextPane
        //Добавлять вкладку в панель tabbedPane с именем "HTML" и компонентом из предыдущего пункта
        tabbedPane.addTab("HTML", new JScrollPane(htmlTextPane));

        //Создавать новый локальный компонент JScrollPane на базе plainTextPane
        //Добавлять еще одну вкладку в tabbedPane с именем "Текст" и компонентом из предыдущего пункта
        tabbedPane.addTab("Текст", new JScrollPane(plainTextPane));

        //Устанавливать предпочтительный размер панели tabbedPane
        tabbedPane.setPreferredSize(new Dimension(800, 600));

        //Создавать объект класса TabbedPaneChangeListener и устанавливать его в качестве слушателя изменений в tabbedPane
        tabbedPane.addChangeListener(new TabbedPaneChangeListener(this));

        //Добавлять по центру панели контента текущего фрейма нашу панель с вкладками
        getContentPane().add(tabbedPane, BorderLayout.CENTER);



    }

    public void  initGui(){
        initMenuBar();
        initEditor();
        pack();
    }

    public void selectedTabChanged()
    {

    }

    public boolean canUndo()
    {
        return false;
    }

    public boolean canRedo()
    {
        return false;
    }
}
