package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ConsoleHelper
{
    static BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static void printExitMessage()
    {
        ConsoleHelper.writeMessage("Terminated. Thank you for visiting JavaRush cash machine. Good luck.");
    }

    public static String readString() throws InterruptOperationException
    {
        String message = "";
        try
        {
            message = reader.readLine().trim();
            if (message.equalsIgnoreCase("EXIT")) throw new InterruptOperationException();
        }
        catch (IOException ignored)
        {
        }
        return message;

    }


    public static String askCurrencyCode() throws InterruptOperationException
    {

        String test;
        writeMessage("Input valute code?");
        while (true)
        {
            test = readString();
            if (test.length() == 3)
                break;
            else
                writeMessage("Valute code is incorrect. Repeat please?");

        }
        test = test.toUpperCase();
        return test;


    }


    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException
    {

        String[] array;
        writeMessage("Input two digital. First - nominal, Second - banknots qantity?");

        while (true)
        {
            String s = readString();
            array = s.split(" ");
            int k;
            int l;
            try
            {
                k = Integer.parseInt(array[0]);
                l = Integer.parseInt(array[1]);
            }
            catch (Exception e)
            {
                writeMessage("Incorrect. \"200 5\" Repast please");
                continue;
            }
            if (k <= 0 || l <= 0 || array.length > 2)
            {
                writeMessage("Incorrect. \"200 5\" Repast please");
                continue;
            }
            break;
        }
        return array;

    }


    public static Operation askOperation() throws InterruptOperationException
    {
        while (true)
        {
            String line = readString();
            if (checkWithRegExp(line))
                return Operation.getAllowableOperationByOrdinal(Integer.parseInt(line));
            else
                writeMessage("Ведите номер операции");
        }

    }



    public static boolean checkWithRegExp(String Name)
    {
        Pattern p = Pattern.compile("^[1-4]$");
        Matcher m = p.matcher(Name);
        return m.matches();
    }



}
