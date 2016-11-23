package com.javarush.test.level26.lesson15.big01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class ConsoleHelper
{
    public static final BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString() throws IOException
    {
        return bf.readLine();
    }


    public static String askCurrencyCode() throws IOException
    {
        String strInVal;
        while(true){
            System.out.println("Input valute code?");
            strInVal=readString();
            if(strInVal.length()==3 && checkString(strInVal)){
                return strInVal.toUpperCase();
            }else{
                System.out.println("Valute code is incorrect. Repeat please?");
            }
        }
    }


    public static String[] getValidTwoDigits(String currencyCode) throws IOException
    {

        String[] strArrInVal;
        while(true){
            System.out.println("Input two digital. First - nominal, Second - banknots qantity?");
            strArrInVal=readString().split(" ");

            if(strArrInVal.length==2 && checkString(strArrInVal[0]) && checkString(strArrInVal[1]) &&
                    (Integer.parseInt(strArrInVal[0])>0)&&(Integer.parseInt(strArrInVal[1])>0)){

                return strArrInVal;
            }else{
                System.out.println("Incorrect. \"200 5\" Repast please");
            }
        }

    }

    public static boolean checkString(String string) {
        if (string == null) return false;
        return string.matches("^-?\\d+$");
    }

}
