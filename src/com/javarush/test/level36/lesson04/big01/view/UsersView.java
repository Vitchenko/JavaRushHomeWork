package com.javarush.test.level36.lesson04.big01.view;

import com.javarush.test.level36.lesson04.big01.controller.Controller;
import com.javarush.test.level36.lesson04.big01.model.ModelData;

/**
 * Created by viv on 22.12.2016.
 */
public class UsersView implements View
{
    private Controller controller;


    public void fireEventShowDeletedUsers() {
        controller.onShowAllDeletedUsers();
    }

@Override
public void refresh(ModelData modelData) {
    //if (!modelData.isDisplayDeletedUserList()) {
        System.out.println("All users:");
    //}
    //if (modelData.isDisplayDeletedUserList()) {
    //    System.out.println("All deleted users:");
    //}

    //Выведи в консоль всех юзеров, которые есть в modelData
    //Перед каждым юзером сделай отступ в виде табуляции
    for (int i = 0; i < modelData.getUsers().size(); i++) {
        System.out.println("\t" + modelData.getUsers().get(i));
    }
    //В конце выведи визуальный разделитель данных
    System.out.println("===================================================");
}
    @Override
    public void setController(Controller controller)
    {
        this.controller=controller;
    }

    public void fireEventShowAllUsers(){
        controller.onShowAllUsers();
    }

}
