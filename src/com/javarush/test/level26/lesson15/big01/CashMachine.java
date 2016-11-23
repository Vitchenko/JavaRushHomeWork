package com.javarush.test.level26.lesson15.big01;

import java.io.IOException;
import java.util.Locale;

import static com.javarush.test.level26.lesson15.big01.ConsoleHelper.getValidTwoDigits;
import static com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory.getManipulatorByCurrencyCode;

public class CashMachine
{
    public static void main(String[] args) throws IOException
    {
        Locale.setDefault(Locale.ENGLISH);
        String strCodVal= ConsoleHelper.askCurrencyCode();
        String[] arrDenCount=getValidTwoDigits(strCodVal);
        CurrencyManipulator cn=getManipulatorByCurrencyCode(strCodVal);
        cn.addAmount(Integer.parseInt(arrDenCount[0]),Integer.parseInt(arrDenCount[1]));
        ConsoleHelper.bf.close();
    }
}
