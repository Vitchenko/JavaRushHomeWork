package com.javarush.test.level32.lesson15.big01;

import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.File;


public class Controller
{
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public HTMLDocument getDocument()
    {
        return document;
    }

    public Controller(View view)
    {
        this.view = view;
    }

    public void init(){

    }

     public void exit(){
         System.exit(0);
     }

    public static void main(String[] args)
    {
        View view=new View();
        Controller controller=new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();
    }



    /**Добавь в контроллер метод resetDocument(), который будет сбрасывать текущий документ. Он
     должен:
     15.1.	Удалять у текущего документа document слушателя правок которые можно
     отменить/вернуть (найди подходящий для этого метод, унаследованный от
     AbstractDocument). Слушателя нужно запросить у представления (метод getUndoListener()).
     Не забудь проверить, что текущий документ существует (не null).
     15.2.	Создавать новый документ по умолчанию и присваивать его полю document.
     Подсказка: воспользуйся подходящим методом класса HTMLEditorKit.
     15.3.	Добавлять новому документу слушателя правок.
     15.4.	Вызывать у представления метод update().
     */

    public void resetDocument(){
        if (document != null) {
            //Удалять у текущего документа document слушателя правок которые можно отменить/вернуть
            document.removeUndoableEditListener(view.getUndoListener());
        }
        //Создавать новый документ по умолчанию и присваивать его полю document
        document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
        //Добавлять новому документу слушателя правок
        document.addUndoableEditListener(view.getUndoListener());
        //Вызывать у представления метод update()
        view.update();
    }
}
