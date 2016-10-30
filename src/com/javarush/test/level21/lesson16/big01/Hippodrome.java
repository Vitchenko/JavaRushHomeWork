package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;
import java.util.List;
/*
Теперь вернемся к методам move и print. Начнем с move.


*/
public class Hippodrome
{

    public static ArrayList<Horse> horses = new ArrayList<Horse>();
    public static Hippodrome game;

    public ArrayList<Horse> getHorses()
    {
        return horses;
    }



    public static void main(String[] args) throws InterruptedException
    {

        game = new Hippodrome();
        Horse hor1=new Horse("hor11",3,0);
        Horse hor2=new Horse("hor12",3,0);
        Horse hor3=new Horse("hor13",3,0);

        game.getHorses().add(hor1);
        game.getHorses().add(hor2);
        game.getHorses().add(hor3);
        game.run();

        game.printWinner();

    }


    public void run() throws InterruptedException
    {
        for(int i=1;i<=100;i++){
                move();
                print();
                Thread.sleep(200);
            }
    }

    public void move()
    {
        for(int i=0;i<getHorses().size();i++){
            getHorses().get(i).move();
        }
    }

    public void print()
    {
        for(int i=0;i<getHorses().size();i++){
            getHorses().get(i).print();
        }
        System.out.println();
        System.out.println();
    }
//    Добавим определение победителя.
//    В классе Hippodrome сделаем два метода:
//    public Horse getWinner() и public void printWinner()
//
//    Метод getWinner должен возвращать лошадь пробежавшую самую большую дистанцию.
//    Метод printWinner выводит на экран имя победителя в виде:
//    Winner is <NAME>!
//    Пример:    Winner is Lucky!
    public Horse getWinner(){

        Double maxD=getHorses().get(0).getDistance();;

        for(int i=1;i<getHorses().size();i++){
            if (maxD<getHorses().get(i).getDistance()){
            maxD=getHorses().get(i).getDistance();}
        }

        for(int i=0;i<getHorses().size();i++){
            if(getHorses().get(i).getDistance()==maxD){
                return getHorses().get(i);
            }
        }

        return null;
    }

    public void printWinner(){
        System.out.println("Winner is "+getWinner().getName()+"!");
        }


}
