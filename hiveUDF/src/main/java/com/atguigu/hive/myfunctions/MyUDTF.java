package com.atguigu.hive.myfunctions;


import netscape.javascript.JSException;
import org.apache.hadoop.hive.ql.exec.UDFArgumentException;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDTF;
import org.apache.hadoop.hive.serde2.objectinspector.*;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.PrimitiveObjectInspectorFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @time 2020/4/3 - 14:36
 * @Version 1.0
 * @Author Jeffery Yi
 */
public class MyUDTF extends GenericUDTF{

    @Override
    public StructObjectInspector initialize(StructObjectInspector argOIs) throws UDFArgumentException {
        List<? extends StructField> inputFields = argOIs.getAllStructFieldRefs();

        if (inputFields.size() != 1){
            throw new UDFArgumentException("参数只能是一个！");
        }

        if (!"string".equals(inputFields.get(0).getFieldObjectInspector().getTypeName())){
            throw new UDFArgumentException("参数必须是 string 类型");
        }

        ArrayList<String> fieldNames = new ArrayList<>();
        fieldNames.add("event_name");
        fieldNames.add("event_json");

        ArrayList<ObjectInspector> fieldOIs = new ArrayList<>();
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);

        return ObjectInspectorFactory.getStandardStructObjectInspector(fieldNames, fieldOIs);
    }

    @Override
    public void process(Object[] objects) throws HiveException {
        if (objects[0] == null || objects.length ==0){
            return;
        }

        try {
            JSONArray jsonArray = new JSONArray(objects[0].toString());
            for (int i = 0; i < jsonArray.length(); i++) {
                String[] result = new String[2];

                JSONObject eventJSON = jsonArray.getJSONObject(i);
                result[0] = eventJSON.getString("en");
                result[1] = eventJSON.toString();

                // System.out.println(Arrays.asList(result));
                forward(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws HiveException {

    }
}

