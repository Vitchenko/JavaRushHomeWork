package com.javarush.test.level37.lesson10.big01;

import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by viv on 23.12.2016.
 */
public class AmigoSet<E> extends AbstractSet<E> implements Cloneable, Serializable, Set<E>{

    @Override
    public Iterator<E> iterator()
    {
        return null;
    }

    @Override
    public int size()
    {
        return 0;
    }
}
