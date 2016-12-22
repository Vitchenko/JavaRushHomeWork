package com.javarush.test.level36.lesson04.big01.model;

import com.javarush.test.level36.lesson04.big01.bean.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by viv on 21.12.2016.
 */
public class ModelData
{
    private List<User> users=new ArrayList<>();

    {
        users.add(new User("A",1,1));
        users.add(new User("B",2,2));
    }

    public List<User> getUsers()
    {
        return users;
    }

    public void setUsers(List<User> users)
    {
        this.users = users;
    }
}
