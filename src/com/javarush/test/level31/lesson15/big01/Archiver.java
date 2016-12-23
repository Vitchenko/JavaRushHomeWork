package com.javarush.test.level31.lesson15.big01;

import com.javarush.test.level31.lesson15.big01.exception.PathIsNotFoundException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Archiver
{
    public static void main(String[] args) throws Exception, PathIsNotFoundException
    {

        System.out.println("Введите путь к файлу архива?");
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        String textPath=bf.readLine();

        Path path=Paths.get(textPath);
        ZipFileManager zipFileManager=new ZipFileManager(path);

        System.out.println("Введите путь к файлу который будем архивировать?");
        String textPath2=bf.readLine();

        zipFileManager.createZip(Paths.get(textPath2));
    }

}
