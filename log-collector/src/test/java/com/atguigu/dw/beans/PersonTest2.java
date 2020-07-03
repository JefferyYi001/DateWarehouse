package com.atguigu.dw.beans;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.List;

/**
 * @time 2020/3/25 - 21:06
 * @Version 1.0
 * @Author Jeffery Yi
 */
public class PersonTest2 {
    @Test
    public void testExample1(){
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("id", 1001);
        jsonObject.put("name", "jack");
        jsonObject.put("gender", "female");

        System.out.println(jsonObject);


    }

    @Test
    public void testExample2(){
        String string = "{\"gender\":\"female\",\"name\":\"jack\",\"id\":1001}";

        Person person = JSON.parseObject(string, Person.class);
        System.out.println(person);

        String string1 = JSON.toJSONString(person);
        System.out.println(string1);

        String string2 = "[{\"gender\":\"male\",\"name\":\"jack\",\"id\":1001},{\"gender\":\"female\",\"name\":\"rose\",\"id\":1002}]";
        List<Person> parseArray = JSON.parseArray(string2, Person.class);
        System.out.println(parseArray);

    }

    @Test
    public void testExample3(){

        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("id", 1001);
        jsonObject1.put("name", "jack");
        jsonObject1.put("gender", "male");

        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("id", 1002);
        jsonObject2.put("name", "rose");
        jsonObject2.put("gender", "female");

        JSONArray jsonArray = new JSONArray();
        jsonArray.add(jsonObject1);
        jsonArray.add(jsonObject2);

        System.out.println(jsonArray);
    }
}
