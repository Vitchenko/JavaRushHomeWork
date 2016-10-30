package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

/**
 * Created by viv on 18.09.2016.
 */
public class ImageReaderFactory
{
    private static ImageReader outReader;

    public static ImageReader getReader(ImageTypes imtype){


        if(imtype==ImageTypes.BMP){
            outReader= new BmpReader();
        }else if(imtype==ImageTypes.JPG){
            outReader=new JpgReader();
        }else if(imtype==ImageTypes.PNG){
            outReader=new PngReader();
        } else {
            throw new IllegalArgumentException();
        }

        return outReader;
    }

}
