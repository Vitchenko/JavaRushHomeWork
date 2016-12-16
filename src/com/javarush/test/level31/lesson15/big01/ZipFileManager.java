package com.javarush.test.level31.lesson15.big01;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipOutputStream;

/**
 * Created by viv on 16.12.2016.
 */
public class ZipFileManager
{
    private Path zipFile;

    public ZipFileManager(Path zipFile)
    {
        this.zipFile = zipFile;
    }

    /**Чтобы заархивировать файл (создать новый архив и добавить в него файл):
     1.	Создай новый поток архива ZipOutputStream используя перемнную класса zipFile, с помощью метода
     newOutputStream класса Files.
     2.	Создай новый элемент архива ZipEntry. В конструктор ZipEntry передай строку, содержащую имя новой записи.
     Имя нужно получить из полного пути source, взять только имя файла и сконвертировать его в String.
     3.	Добавь в поток архива созданный элемент архива.
     4.	Перепиши данные из файла, который архивируем в поток архива. Для этого:
     4.1. создай поток InputStream для добавляемого файла source, используя метод newInputStream класса Files
     4.2. сделай цикл, который будет читать данные из InputStream (созданного в п.4.1), пока они там есть и записывать
     их в ZipOutputStream (созданный в п.1)
     4.3. закрой InputStream, сделай это с помощью try-with-resources
     5.	Закрой элемент архива у потока архива
     6.	Закрой поток архива, сделай это также с помощью try-with-resources
     7.	Запусти программу и проверь, что файл архивируется*/

    public void createZip(Path source) throws Exception {

    }
}
