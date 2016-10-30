package com.javarush.test.level20.lesson07.task04;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* Serializable Solution
Сериализуйте класс Solution.
Подумайте, какие поля не нужно сериализовать, пометить ненужные поля — transient.
Объект всегда должен содержать актуальные итоговые данные.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать файл, открыть поток на чтение (input stream) и на запись(output stream)
2) создать экземпляр класса Solution - savedObject
3) записать в поток на запись savedObject (убедитесь, что они там действительно есть)
4) создать другой экземпляр класса Solution с другим параметром
5) загрузить из потока на чтение объект - loadedObject
6) проверить, что savedObject.string равна loadedObject.string
7) обработать исключения
*/
public class Solution implements Serializable
{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        System.out.println(new Solution(4));

        //save cat to file
        FileOutputStream fileOutput = new FileOutputStream("d:/ss.dat");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);

        Solution savedObject=new Solution(5);

        outputStream.writeObject(savedObject);
        fileOutput.close();
        outputStream.close();

        //load cat from file
        FileInputStream fiStream = new FileInputStream("d:/ss.dat");
        ObjectInputStream objectStream = new ObjectInputStream(fiStream);
        Solution loadedObject =(Solution) objectStream.readObject();
        fiStream.close();
        objectStream.close();

        if (savedObject.string.equals(loadedObject.string)){
            System.out.println(savedObject.string);
            System.out.println(loadedObject.string);
        }
    }

    private final transient String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution() throws IOException
    {
        super();
    }

    public Solution(int temperature) throws IOException
    {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }



    @Override
    public String toString() {
        return this.string;
    }
}
