package com.javarush.test.level33.lesson15.big01;

import com.javarush.test.level33.lesson15.big01.strategies.StorageStrategy;

/**
 Вернемся к классу Shortener:
 3.1.	Добавь в него поле Long lastId. Проинициализируй его нулем. Это поле будет
 отвечать за последнее значение идентификатора, которое было использовано при
 добавлении новой строки в хранилище.
 3.2.	Добавь поле StorageStrategy storageStrategy в котором будет храниться стратегия
 хранения данных.
 3.3.	Добавь конструктор, который принимает StorageStrategy и инициализирует
 соответствующее поле класса.
 3.4.	Реализуй метод getId, он должен:
 3.4.1.	Проверить есть ли переданное значение в хранилище, если есть – вернуть
 его ключ.
 3.4.2.	Если преданного значения нет в хранилище, то:
 3.4.2.1.	Увеличить значение lastId;
 3.4.2.2.	Добавить в хранилище новую пару ключ-значение (новое значение
 lastId и переданную строку);
 3.4.2.3.	Вернуть новое значение lastId.
 3.5.	Реализуй метод getString, он должен вернуть строку по заданному идентификатору
 (ключу).
 3.6.	Предусмотреть возможность вызова методов getId и getString из разных потоков.
 */
public class Shortener
{

    private Long lastId=Long.valueOf(0);
    private StorageStrategy storageStrategy;

    public Shortener(StorageStrategy storageStrategy)
    {
        this.storageStrategy = storageStrategy;
    }

    public synchronized Long getId(String string){

        Long value=null;

        if (storageStrategy.containsValue(string)){
            value=storageStrategy.getKey(string);
        }else{

            storageStrategy.put(++lastId,string);
            value=lastId;
        }


        return value;
    }

    public synchronized String getString(Long id){

        if(storageStrategy.containsKey(id)){
            return storageStrategy.getValue(id);
        }

        return null;
    }

}
