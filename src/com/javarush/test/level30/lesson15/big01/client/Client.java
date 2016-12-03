package com.javarush.test.level30.lesson15.big01.client;


import com.javarush.test.level30.lesson15.big01.Connection;
import com.javarush.test.level30.lesson15.big01.ConsoleHelper;
import com.javarush.test.level30.lesson15.big01.Message;
import com.javarush.test.level30.lesson15.big01.MessageType;

import java.io.IOException;
import java.net.Socket;


public class Client
{
    protected Connection connection;
    private volatile boolean clientConnected = false;

    public class SocketThread extends Thread
    {

        public void run()
        {
            try
            {
                Socket socket = new Socket(getServerAddress(), getServerPort());
                Client.this.connection=new Connection(socket);
                clientHandshake();
                clientMainLoop();
            }
            catch (IOException e)
            {
                notifyConnectionStatusChanged(false);
            }
            catch (ClassNotFoundException e)
            {
                notifyConnectionStatusChanged(false);
            }

        }

        /**
         * Последний, но самый главный метод класса SocketThread – это метод void run(). Добавь
         * его. Его реализация с учетом уже созданных методов выглядит очень просто. Давай
         * напишем ее:
         * 17.1.	Запроси адрес и порт сервера с помощью методов getServerAddress() и
         * getServerPort().
         * 17.2.	Создай новый объект класса java.net.Socket, используя данные, полученные в
         * п.17.1.
         * 17.3.	Создай объект класса Connection, используя сокет из п.17.2.
         * 17.4.	Вызови метод, реализующий "рукопожатие" клиента с сервером
         * (clientHandshake()).
         * 17.5.	Вызови метод, реализующий основной цикл обработки сообщений сервера.
         * 17.6.	При возникновении исключений IOException или ClassNotFoundException
         * сообщи главному потоку о проблеме, используя notifyConnectionStatusChanged и false
         * в качестве параметра.
         * Клиент готов, можешь запустить сервер, несколько клиентов и проверить как все работает.
         */

        protected void processIncomingMessage(String message)
        {
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName)
        {
            ConsoleHelper.writeMessage("Участник с именем " + userName + " присоединился к чату");
        }

        protected void informAboutDeletingNewUser(String userName)
        {
            ConsoleHelper.writeMessage("Участник с именем " + userName + " покинул чат");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected)
        {
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this)
            {
                Client.this.notify();
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException
        {
            while (true)
            {
                Message message = connection.receive();
                switch (message.getType())
                {
                    case NAME_REQUEST:
                    {
                        String userName = getUserName();
                        connection.send(new Message(MessageType.USER_NAME, userName));
                        break;
                    }
                    case NAME_ACCEPTED:
                    {
                        notifyConnectionStatusChanged(true);
                        return;
                    }

                    default:
                    {
                        throw new IOException("Unexpected MessageType");
                    }
                }
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException
        {

            while (true)
            {
                Message message = connection.receive();
                switch (message.getType())
                {
                    case TEXT:
                        processIncomingMessage(message.getData());
                        break;
                    case USER_ADDED:
                        informAboutAddingNewUser(message.getData());
                        break;
                    case USER_REMOVED:
                        informAboutDeletingNewUser(message.getData());
                        break;

                    default:
                        throw new IOException("Unexpected MessageType");
                }
            }

        }

    }

    protected String getServerAddress()
    {
        ConsoleHelper.writeMessage("Введите ip адресс сервера?");
        return ConsoleHelper.readString();
    }

    protected int getServerPort()
    {
        ConsoleHelper.writeMessage("Введите номер порта сервера?");
        return ConsoleHelper.readInt();
    }

    protected String getUserName()
    {
        ConsoleHelper.writeMessage("Введите имя пользователя?");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSentTextFromConsole()
    {
        return true;
    }

    protected SocketThread getSocketThread()
    {
        return new SocketThread();
    }

    protected void sendTextMessage(String text)
    {

        try
        {
            connection.send(new Message(MessageType.TEXT, text));
        }
        catch (IOException e)
        {
            ConsoleHelper.writeMessage("Сообщение не отправлено");
            clientConnected = false;
        }
    }


    public void run()
    {

        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();

        try
        {
            synchronized (this)
            {
                this.wait();
            }
        }
        catch (InterruptedException e)
        {
            ConsoleHelper.writeMessage("Ошибка порожденного потока демона");
            return;
        }

        if (clientConnected == true)
        {
            ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");

            while (true)
            {
                String str = ConsoleHelper.readString();
                if (str.equals("exit")) break;

                if (shouldSentTextFromConsole() == true)
                {
                    sendTextMessage(str);
                }
            }
        } else
        {
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
        }

    }

    public static void main(String[] args)
    {
        Client client = new Client();
        client.run();
    }


}
