package com.javarush.test.level26.lesson15.big01;

import java.io.IOException;
import java.util.Locale;

public class CashMachine
{
    public static void main(String[] args) throws IOException
    {
        Locale.setDefault(Locale.ENGLISH);
        ConsoleHelper ch = new ConsoleHelper();
        CurrencyManipulatorFactory cmf=null;
        String strCodVal= ch.askCurrencyCode();
        String[] arrDenCount=ch.getValidTwoDigits(strCodVal);
        CurrencyManipulator cn=cmf.getManipulatorByCurrencyCode(strCodVal);
        cn.addAmount(Integer.parseInt(arrDenCount[0]),Integer.parseInt(arrDenCount[1]));
        //ConsoleHelper.bf.close();
    }
}
