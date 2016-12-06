package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.*;

class WithdrawCommand implements Command
{

 /**before=Withdrawing...
  success.format=%d %s was withdrawn successfully
  specify.amount=Please specify integer amount for withdrawing.
  specify.not.empty.amount=Please specify valid positive integer amount for withdrawing.
  not.enough.money=Not enough money on your account, please try again
  exact.amount.not.available=Exact amount is not available*/

    @Override
    public void execute() throws InterruptOperationException{
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        ConsoleHelper.writeMessage("Withdrawing...");
        int sum = 0;
        do {
            ConsoleHelper.writeMessage("Please specify integer amount for withdrawing.");
            try {
                sum = Integer.parseInt(ConsoleHelper.readString());
                if (sum < 0) throw new NumberFormatException("Please specify valid positive integer amount for withdrawing.");
                if (!manipulator.isAmountAvailable(sum)) {
                    ConsoleHelper.writeMessage("Not enough money on your account, please try again");
                    continue;
                }
                Map<Integer, Integer> withdrawBanknotes = manipulator.withdrawAmount(sum);
                withdrawBanknotes.keySet();
                /*Вывести пользователю результат из п. 1.3.4. в следующем виде:
                <табуляция>номинал - количество
                Сортировка - от большего номинала к меньшему.
                Sort by key (denominations) */
                List list = new ArrayList(withdrawBanknotes.entrySet());
                Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
                    @Override
                    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                        return o2.getKey() - o1.getKey();
                    }
                });

                for (Object o : list) {
                    Map.Entry<Integer, Integer> entry = (Map.Entry<Integer, Integer>)o;
                    ConsoleHelper.writeMessage(String.format("\t%d - %d", entry.getKey(), entry.getValue()));
                }
                ConsoleHelper.writeMessage(String.format("%d %s was withdrawn successfully", sum, manipulator.getCurrencyCode()));
                break; //If reached - It's ok. Goto end;
            } catch (NumberFormatException e) {
                ConsoleHelper.writeMessage("Please specify valid positive integer amount for withdrawing.");
            } catch (NotEnoughMoneyException e) {
                ConsoleHelper.writeMessage("Exact amount is not available");
            }
        } while (true);
    }
}
