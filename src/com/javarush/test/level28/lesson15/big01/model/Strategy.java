package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.util.List;

/**
 * Created by viv on 09.11.2016.
 */
public interface Strategy
{
    List<Vacancy> getVacancies(String searchString);

}
