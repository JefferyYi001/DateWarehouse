package com.atguigu.hive.myfunctions;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.hive.ql.exec.UDFArgumentException;
import org.json.JSONObject;

/**
 * @time 2020/4/3 - 14:52
 * @Version 1.0
 * @Author Jeffery Yi
 */
public class MyUDF extends UDF {
    public String evaluate(String source, String param) throws UDFArgumentException {

        if (!source.contains(param) && !"ts".equals(param)){
            throw new UDFArgumentException("请传入正确的参数！");
        }

        if ("cm".equals(param)){
            throw new UDFArgumentException("请传入正确的参数！");
        }

        String[] words = source.split("\\|");

        JSONObject root = new JSONObject(words[1]);

        if ("ts".equals(param)){
            return words[0];
        }else if ("ap".equals(param)){
            return root.getString("ap");
        }else if ("et".equals(param)) {
            return root.getString("et");
        }else {
            return root.getJSONObject("cm").getString(param);
        }
    }
}
