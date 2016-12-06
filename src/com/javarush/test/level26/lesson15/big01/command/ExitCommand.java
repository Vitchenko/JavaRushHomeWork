package com.javarush.test.level26.lesson15.big01.command;


import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

class ExitCommand implements Command
{
    @Override
    public void execute() throws InterruptOperationException
    {
        String commandAck;
        ConsoleHelper.writeMessage("Do you really want to exit? <y,n>");
        commandAck = ConsoleHelper.readString().toLowerCase();
        if (commandAck.equals("y"))
            ConsoleHelper.writeMessage("Thank you for visiting JavaRush cash machine. Good luck.");
    }
}
