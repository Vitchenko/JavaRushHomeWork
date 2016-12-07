package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.Provider;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Controller
{

    private Provider[] providers;

    public Controller(Provider... providers) throws IllegalArgumentException
    {
        if (providers.length == 0) {throw new IllegalArgumentException();}

        this.providers = providers;

    }

    @Override
    public String toString()
    {
        return "Controller{" +"providers=" + Arrays.toString(providers) +'}';
    }
//    Внутри метода пройдись по всем провайдерам и собери с них все вакансии, добавь их в список.
//    Выведи количество вакансий в консоль.
//
//5. Исправь NPE, если появляется это исключение (поставь заглушку).

    public void scan()
    {

        List<Vacancy> vacancies = new ArrayList<>();

        for (Provider provider : providers)
        {
            try
            {
                for (Vacancy vac : provider.getJavaVacancies("SOME TEXT"))
                    vacancies.add(vac);
            }
            catch (NullPointerException e)
            {
                //System.out.println(e);
            }
        }
        System.out.println(vacancies.size());
    }
}
