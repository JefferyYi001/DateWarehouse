package com.atguigu.hive.myfunctions;

import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @time 2020/4/3 - 16:53
 * @Version 1.0
 * @Author Jeffery Yi
 */
public class MyUDTFTest {

    @Test
    public void process() throws HiveException {

        String str = "[{\"ett\":\"1586595823882\",\"en\":\"ad\",\"kv\":{\"activityId\":\"1\",\"displayMills\":\"84470\",\"entry\":\"1\",\"action\":\"1\",\"contentType\":\"0\"}},{\"ett\":\"1586525960461\",\"en\":\"active_background\"}]";
        Object[] objects = new Object[1];
        objects[0] = str;

        new MyUDTF().process(objects);
    }

}