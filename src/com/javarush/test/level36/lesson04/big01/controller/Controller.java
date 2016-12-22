package com.javarush.test.level36.lesson04.big01.controller;

import com.javarush.test.level36.lesson04.big01.model.Model;
import com.javarush.test.level36.lesson04.big01.model.ModelData;
import com.javarush.test.level36.lesson04.big01.view.UsersView;

/**
 * Created by viv on 22.12.2016.
 */
public class Controller
{
    private Model model;
    private UsersView usersView;


    public void setModel(Model model)
    {
        this.model = model;
    }

    public void onShowAllUsers(){
        model.loadUsers();
        usersView.refresh(model.getModelData());
    }

    public void setUsersView(UsersView usersView)
    {
        this.usersView = usersView;
    }

    //Пойди в контроллер и добавь обновление данных во Вью.   Напомню, данные хранятся в Моделе.
}
