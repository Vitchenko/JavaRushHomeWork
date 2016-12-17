package com.javarush.test.level33.lesson15.big01.strategies;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by viv on 17.12.2016.
 */
public class HashMapStorageStrategy implements StorageStrategy
{
    private HashMap<Long, String> data=new HashMap<>();

    @Override
    public boolean containsKey(Long key)
    {
        return data.containsKey(key);
    }

    @Override
    public boolean containsValue(String value)
    {
        return data.containsValue(value);
    }

    @Override
    public void put(Long key, String value)
    {
        data.put(key,value);
    }

    @Override
    public Long getKey(String value)
    {
        if(data.containsValue(value)){
            for(Map.Entry<Long, String> arr:data.entrySet()){
                if(arr.getValue().equals(value)){
                    return arr.getKey();
                }
            }
        }
        return null;
    }

    @Override
    public String getValue(Long key)
    {
        if(data.containsKey(key)){
            return data.get(key);
        }
        return null;
    }
}
