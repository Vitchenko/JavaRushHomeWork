package com.javarush.test.level37.lesson04.big01;

import com.javarush.test.level37.lesson04.big01.female.FemaleFactory;
import com.javarush.test.level37.lesson04.big01.male.MaleFactory;

/**
 * Created by viv on 23.12.2016.
 */

    public class FactoryProducer {

        public static enum HumanFactoryType {
            MALE, FEMALE
        }

        public static AbstractFactory getFactory(HumanFactoryType humanFactoryType) {
            if (humanFactoryType.equals(HumanFactoryType.MALE)) {
                return (AbstractFactory) new MaleFactory();
            }
            else {
                return (AbstractFactory) new FemaleFactory();
            }
        }
    }

