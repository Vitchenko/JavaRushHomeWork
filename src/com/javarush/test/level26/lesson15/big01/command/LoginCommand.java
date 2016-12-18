package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

public class LoginCommand implements Command
{
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "verifiedCards");
//    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "login_en");

    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage("Logging in...");
        while (true)
        {
            ConsoleHelper.writeMessage("Please specify your credit card number and pin code or type 'EXIT' for exiting.");
            String s1 = ConsoleHelper.readString();
            String s2 = ConsoleHelper.readString();
  /**4. Реализуйте следующую логику для команды LoginCommand:
   4.1. Пока пользователь не введет валидные номер карты и пин - выполнять следующие действия
   4.2. Запросить у пользователя 2 числа - номер кредитной карты, состоящий из 12 цифр, и пин - состоящий из 4 цифр
   4.3. Вывести юзеру сообщение о невалидных данных, если они такими являются.
   4.4. Если данные валидны, то проверить их на соответствие захардкоженным (123456789012 и 1234).
   4.5. Если данные в п. 4.4. идентифицированы, то сообщить, что верификация прошла успешно.
   4.6. Если данные в п. 4.4. НЕ идентифицированы, то вернуться к п.4.1.
   */


            if (validCreditCards.containsKey(s1))
            {
                if (validCreditCards.getString(s1).equals(s2))
                    ConsoleHelper.writeMessage(String.format("Credit card [%s] is verified successfully!", s1));
                else
                {
                    ConsoleHelper.writeMessage(String.format("Credit card [%s] is not verified.", s1));
                    ConsoleHelper.writeMessage("Please try again or type 'EXIT' for urgent exiting");
                    continue;
                }
            }
            else
            {
                ConsoleHelper.writeMessage(String.format("Credit card [%s] is not verified.", s1));
                ConsoleHelper.writeMessage("Please specify valid credit card number - 12 digits, pin code - 4 digits.");
                continue;
            }

            break;
        }

    }
}