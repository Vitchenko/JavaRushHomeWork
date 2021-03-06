package com.javarush.test.level24.lesson04.task01;

import java.math.BigDecimal;

/* Наследование от внутреннего класса
Внутри класса Solution создайте 2 внутренних public класса Apt3Bedroom, BigHall.
Унаследуйте их от Apartments и Hall.
public class Car
{
 public class Door { }
}

public class LamborginiDoor extends Car.Door
{
 LamborginiDoor(Car car)
 {
  car.super();
 }
}
*/
public class Solution {
    public class Building {
        public class Hall {
            private BigDecimal square;

            public Hall(BigDecimal square) {
                this.square = square;
            }
        }

        public class Apartments {
        }
    }

    public class Apt3Bedroom extends Building.Apartments{
        Apt3Bedroom(Building build)
        {
            build.super();
        }
    }

    public class BigHall extends Building.Hall{
        BigHall(Building build, BigDecimal square)
        {

            build.super(square);
        }
    }
}
