package com.javarush.test.level32.lesson15.big01;

import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;


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
        createNewDocument();
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
/**Добавь метод setPlainText(String text) в контроллер. Он будет записывать переданный текст с
 html тегами в документ document. При его реализации:
 16.1.	Сбрось документ.
 16.2.	Создай новый реадер StringReader на базе переданного текста.
 16.3.	Вызови метод read() из класса HTMLEditorKit, который вычитает данные из реадера в
 документ document.
 16.4.	Проследи, чтобы метод не кидал исключения. Их необходимо просто логировать.*/

    public void setPlainText(String text) {
        //Сбрось документ
        resetDocument();
        //Создай новый реадер StringReader на базе переданного текста
        StringReader stringReader = new StringReader(text);

        try {
            //Вызови метод read() из класса HTMLEditorKit, который вычитает данные из реадера в документ document
            new HTMLEditorKit().read(stringReader, document, 0);

        } catch (Exception e) {
            //Проследи, чтобы метод не кидал исключения. Их необходимо просто логировать
            ExceptionHandler.log(e);
        }
    }
/**Добавь метод String getPlainText() в контроллер. Он должен получать текст из документа со
 всеми html тегами.
 17.1.	Создай объект StringWriter.
 17.2.	Перепиши все содержимое из документа document в созданный объект с помощью
 метода write класса HTMLEditorKit.
 17.3.	Как обычно, метод не должен кидать исключений.*/
    public String getPlainText() {
        //Создай объект StringWriter
        StringWriter stringWriter = new StringWriter();
        try {
            //Перепиши все содержимое из документа document в созданный объект с помощью метода write класса HTMLEditorKit
            new HTMLEditorKit().write(stringWriter, document, 0, document.getLength());

        } catch (Exception e) {
            //Как обычно, метод не должен кидать исключений
            ExceptionHandler.log(e);
        }

        return stringWriter.toString();
    }

    public void createNewDocument()
    {
            //Выбирать html вкладку у представления
        view.selectHtmlTab();
        //Сбрасывать текущий документ
        resetDocument();
        //Устанавливать новый заголовок окна
        view.setTitle("HTML редактор");
        //Сбрасывать правки в Undo менеджере
        view.resetUndo();
        //Обнулить переменную currentFile
        currentFile = null;

    }

    public void openDocument()
    {

        // Метод должен работать аналогично методу saveDocumentAs(), в той части, которая отвечает за выбор файла

        //Переключать представление на html вкладку
        view.selectHtmlTab();
        //Создавать новый объект для выбора файла JFileChooser
        JFileChooser jFileChooser = new JFileChooser();
        //Устанавливать ему в качестве фильтра объект HTMLFileFilter
        jFileChooser.setFileFilter(new HTMLFileFilter());
        //Показывать диалоговое окно "Save File" для выбора файла
        int n = jFileChooser.showOpenDialog(view);

        //Когда файл выбран, необходимо
        if (n == JFileChooser.APPROVE_OPTION) {
            //Установить новое значение currentFile
            currentFile = jFileChooser.getSelectedFile();
            //Сбросить документ
            resetDocument();
            //Установить имя файла в заголовок у представления
            view.setTitle(currentFile.getName());

            //Создать FileReader, используя currentFile
            try (FileReader fileReader = new FileReader(currentFile)) {
                //Вычитать данные из FileReader-а в документ document с помощью объекта класса
                new HTMLEditorKit().read(fileReader, document, 0);
                //Сбросить правки
                view.resetUndo();
            }
            catch (Exception e) {
                ExceptionHandler.log(e);
            }
        }

    }

    public void saveDocument()
    {

        // Метод должен работать также, как saveDocumentAs(), но не запрашивать файл у пользователя,
        // а использовать currentFile. Если currentFile равен null, то вызывать метод saveDocumentAs().

        if (currentFile == null) {
            saveDocumentAs();
        }
        else {
            //Переключать представление на html вкладку
            view.selectHtmlTab();

            //Создавать FileWriter на базе currentFile
            try (FileWriter fileWriter = new FileWriter(currentFile)) {
                //Переписывать данные из документа document в объекта FileWriter-а аналогично тому, как мы это делали в методе getPlainText()
                new HTMLEditorKit().write(fileWriter, document, 0, document.getLength());
            }
            catch (Exception e) {
                ExceptionHandler.log(e);
            }
        }
    }



    public void saveDocumentAs() {

        //Переключать представление на html вкладку
        view.selectHtmlTab();
        //Создавать новый объект для выбора файла JFileChooser
        JFileChooser jFileChooser = new JFileChooser();
        //Устанавливать ему в качестве фильтра объект HTMLFileFilter
        jFileChooser.setFileFilter(new HTMLFileFilter());
        //Показывать диалоговое окно "Save File" для выбора файла
        int n = jFileChooser.showSaveDialog(view);

        //Если пользователь подтвердит выбор файла:
        if (n == JFileChooser.APPROVE_OPTION) {
            //Сохранять выбранный файл в поле currentFile
            currentFile = jFileChooser.getSelectedFile();
            //Устанавливать имя файла в качестве заголовка окна представления
            view.setTitle(currentFile.getName());

            //Создавать FileWriter на базе currentFile
            try (FileWriter fileWriter = new FileWriter(currentFile)) {
                //Переписывать данные из документа document в объекта FileWriter-а аналогично тому, как мы это делали в методе getPlainText()
                new HTMLEditorKit().write(fileWriter, document, 0, document.getLength());
            }
            catch (Exception e) {
                ExceptionHandler.log(e);
            }
        }
    }
}
