package com.javarush.test.level20.lesson10.home03;

import java.io.*;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите проблему и исправьте ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
Метод main не участвует в тестировании.
*/
public class Solution {

    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        Solution.A a = new Solution.A("S");
        System.out.println(a.name+":a before");
        Solution.B b = new Solution().new B("S");
        System.out.println(b.name+":b before");
        FileOutputStream output = new FileOutputStream("D:/1.txt");
        ObjectOutputStream out = new ObjectOutputStream(output);
        out.writeObject(b);
        out.flush();
        out.close();
        output.flush();
        output.close();
        FileInputStream input = new FileInputStream("D:/1.txt");
        ObjectInputStream in = new ObjectInputStream(input);
        Solution.B new_b = (Solution.B)in.readObject();
        System.out.println(new_b.name+":b after");
        in.close();
        input.close();
    }

    public static class A {
        public String name = "A";

        public A(){}

        public A(String name) {
            this.name += name;
        }

        String getName(){
            return name;
        }
    }

    public class B extends A implements Serializable {

        static final long serialVersionUID = 1L;
        public B(String name) {
            super(name);
            this.name += name;
        }

        String getName(){
            return name;
        }

        private void writeObject(ObjectOutputStream out) throws IOException {

            out.writeUTF(this.name);
        }

        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {

            this.name = (String)in.readUTF();
        }

    }
}
