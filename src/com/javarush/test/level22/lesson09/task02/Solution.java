package com.javarush.test.level22.lesson09.task02;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {

    public static void main(String[] args)
    {
        Map<String, String> map=new LinkedHashMap<>();
        map.put("name", null);
        map.put("country", null);
        map.put("city", null);
        map.put("age", null);
        map.put("height", null);
        System.out.println(getCondition(map));
    }


    public static StringBuilder getCondition(Map<String, String> params) {

        StringBuilder sb=new StringBuilder();
        StringBuilder sb2=new StringBuilder();
        for (Map.Entry<String, String> pair : params.entrySet())
        {

            String key = pair.getKey();                      //ключ
            String value = pair.getValue();                  //значение
            if(value!=null && !value.isEmpty()){
                sb.append(key+" = "+"'"+value+"'"+" and ");
            }

        }
        if (sb.length()>0){
        sb.delete(sb.lastIndexOf("and")-1,sb.length());}
        //sb2.append("\""+sb+"\"");

        return sb;
    }
}
