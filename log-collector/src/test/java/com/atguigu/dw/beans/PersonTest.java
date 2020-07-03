package com.atguigu.dw.beans;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @time 2020/3/25 - 20:31
 * @Version 1.0
 * @Author Jeffery Yi
 */
public class PersonTest {
    @Test
    public void testExample1(){
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("id", 1001);
        jsonObject.put("name", "jack");
        jsonObject.put("gender", "male");

        // {"gender":"male","name":"jack","id":1001}
        System.out.println(jsonObject.toJSONString());
    }

    @Test
    public void testExample2(){
        String string = "{\"gender\":\"male\",\"name\":\"jack\",\"id\":1001}";
        Person person = JSON.parseObject(string, Person.class);
        System.out.println(person);

        String string2 = "[{\"gender\":\"male\",\"name\":\"jack\",\"id\":1001},{\"gender\":\"female\",\"name\":\"lucy\",\"id\":1002}]";
        List<Person> personList = JSON.parseArray(string2, Person.class);
        System.out.println(personList);

        JSONArray jsonArray = new JSONArray(Collections.singletonList(personList));
        System.out.println(jsonArray.get(0));
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

        ArrayList<JSONObject> jsonObjects = new ArrayList<>();
        jsonObjects.add(jsonObject1);
        jsonObjects.add(jsonObject2);

        // JSONArray jsonArray = new JSONArray(Collections.singletonList(jsonObjects));
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(jsonObject1);
        jsonArray.add(jsonObject2);

        // System.out.println(jsonArray.toJSONString());
        System.out.println(jsonArray.get(0));
        System.out.println(jsonArray.get(1));
    }
}