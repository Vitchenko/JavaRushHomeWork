package com.javarush.test.level36.lesson04.big01.model;

/**
 * Created by viv on 21.12.2016.
 */
public class FakeModel implements Model
{
    ModelData modelData=new ModelData();


    @Override
    public ModelData getModelData()
    {
        return null;
    }

    @Override
    public void loadUsers()
    {

    }
}
