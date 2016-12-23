package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.List;



public class Order
{

    private Tablet tablet;
    private List<Dish> dishes;


    public Order(Tablet tablet) throws IOException {

        this.dishes = ConsoleHelper.getAllDishesForOrder();
        this.tablet = tablet;
    }

    public int getTotalCookingTime(){
        int totalDuration = 0;
        for (Dish dish : dishes) {
            totalDuration += dish.getDuration();
        }
        return totalDuration;
    }

    @Override
    public String toString() {
        if (dishes.isEmpty()) {
            return "";
        }
        else {
            return "Your order: " + dishes.toString() +" of "+  tablet.toString();
        }

    }


    public boolean isEmpty()
    {
        return dishes == null || dishes.isEmpty();
    }

    public Tablet getTablet()
    {
        return tablet;
    }

    public List<Dish> getDishes()
    {
        return dishes;
    }
}
