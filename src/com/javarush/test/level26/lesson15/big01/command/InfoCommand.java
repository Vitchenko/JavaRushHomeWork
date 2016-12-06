package com.javarush.test.level26.lesson15.big01.command;


import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;


class InfoCommand implements Command
{
    @Override
    public void execute() throws InterruptOperationException
    {
        //private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + ".info");
        ConsoleHelper.writeMessage("Information:");
        for (CurrencyManipulator manipulator : CurrencyManipulatorFactory.getAllCurrencyManipulators()) {
            if (manipulator.hasMoney())
                ConsoleHelper.writeMessage(String.format("%s - %s", manipulator.getCurrencyCode(), manipulator.getTotalAmount()));
            else ConsoleHelper.writeMessage("No money available.");
        }
        if (CurrencyManipulatorFactory.getAllCurrencyManipulators().isEmpty())
            ConsoleHelper.writeMessage("No money available.");
    }

}
