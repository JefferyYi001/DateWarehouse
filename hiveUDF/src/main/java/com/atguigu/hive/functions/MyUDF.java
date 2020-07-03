package com.atguigu.hive.functions;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.json.JSONObject;

/**
 * Created by VULCAN on 2020/4/2
 *
 * 提供多个evaluate()，方法必须有返回值，不能为void，可以返回null!
 *  ①传入ts，返回时间戳部分
 *  ②传入cm中的某个属性名，返回其属性值
 *  ③传入et，返回[{},{}]
 *
 */
public class MyUDF extends UDF {

    public  String evaluate(String source,String param){

        //对param进行校验，param必须是ts或et或cm中的某个属性名才合法
        if (!source.contains(param) && !"ts".equals(param)){

            return null;

        }

        //param合法，取出对应的参数值
        String[] words = source.split("\\|");

        //将|后面的部分构建为json object
        JSONObject root = new JSONObject(words[1]);

        //如果请求的是时间戳
        if ("ts".equals(param)){

            return words[0];

        }else if ("ap".equals(param)){

            return  root.getString("ap");

        }else if ("et".equals(param)){

            return  root.getString("et");

        }else{
            //取cm中的某个属性值
            return root.getJSONObject("cm").getString(param);

        }

    }
}
