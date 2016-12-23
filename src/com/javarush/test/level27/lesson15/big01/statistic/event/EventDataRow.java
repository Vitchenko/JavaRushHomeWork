package com.javarush.test.level27.lesson15.big01.statistic.event;

/**
 * Created by viv on 23.12.2016.
 */
import java.util.Date;

public interface EventDataRow {

    EventType getType();
    Date getDate();
    int getTime();
}