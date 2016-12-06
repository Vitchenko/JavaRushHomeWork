package com.javarush.test.level26.lesson15.big01;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by viv on 06.12.2016.
 */
public class WithdrawSolutions
{

    public static List<Integer[]> withdrawSolutions(Integer[] values, Integer[] ammounts, int[] variation, int ammount, int position) {

        List<Integer[]> list = new ArrayList<>();
        int value = compute(values, variation);
        if (value < ammount) {
            for (int i = position; i < values.length; i++) {
                if (ammounts[i] > variation[i]) {
                    int[] newvariation = variation.clone();
                    newvariation[i]++;
                    List<Integer[]> newList = withdrawSolutions(values, ammounts, newvariation, ammount, i);
                    if (newList != null) {
                        list.addAll(newList);
                    }
                }
            }
        } else if (value == ammount) {
            list.add(myCopy(variation));
        }
        return list;
    }

    public static int compute(Integer[] values, int[] variation) {
        int ret = 0;
        for (int i = 0; i < variation.length; i++) {
            ret += values[i] * variation[i];
        }
        return ret;
    }

    public static Integer[] myCopy(int[] ar) {
        Integer[] ret = new Integer[ar.length];
        for (int i = 0; i < ar.length; i++) {
            ret[i] = ar[i];
        }
        return ret;
    }

}
