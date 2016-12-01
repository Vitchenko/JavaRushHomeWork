package com.javarush.test.level30.lesson06.home01;

import java.util.concurrent.ForkJoinTask;


public class BinaryRepresentationTask extends ForkJoinTask<String>
{
    private String result;

    public BinaryRepresentationTask(int i)
    {

        int a = i % 2;
        int b = i / 2;
        result = String.valueOf(a);

        if (b > 0) {
            result= new BinaryRepresentationTask(b) + result;
        }


    }

    @Override
    public String getRawResult()
    {
        return null;
    }

    @Override
    protected void setRawResult(String value)
    {

    }

    @Override
    protected boolean exec()
    {
        return false;
    }
}
