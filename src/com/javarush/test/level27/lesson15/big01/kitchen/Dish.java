package com.javarush.test.level27.lesson15.big01.kitchen;

/**
 * Created by viv on 06.11.2016.
 */
public enum Dish
{
    Fish, Steak, Soup, Juice, Water;


    public static String allDishesToString(){

        StringBuffer sb=new StringBuffer();
        String str;
        for(Dish st:Dish.values()){
            sb.append(st+", ");
        }
        str=sb.substring(0,sb.length()-2);
        return str;
    }

}
