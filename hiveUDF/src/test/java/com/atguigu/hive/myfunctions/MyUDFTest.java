package com.atguigu.hive.myfunctions;

import org.apache.hadoop.hive.ql.exec.UDFArgumentException;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @time 2020/4/3 - 15:52
 * @Version 1.0
 * @Author Jeffery Yi
 */
public class MyUDFTest {

    @Test
    public void evaluate() throws UDFArgumentException {
        String str = "1586620821601|{\"cm\":{\"ln\":\"-109.2\",\"sv\":\"V2.2.5\",\"os\":\"8.2.7\",\"g\":\"86I0Y26Y@gmail.com\",\"mid\":\"3\",\"nw\":\"4G\",\"l\":\"es\",\"vc\":\"17\",\"hw\":\"750*1134\",\"ar\":\"MX\",\"uid\":\"3\",\"t\":\"1586583920981\",\"la\":\"-43.6\",\"md\":\"Huawei-1\",\"vn\":\"1.3.9\",\"ba\":\"Huawei\",\"sr\":\"L\"},\"ap\":\"app\",\"et\":[{\"ett\":\"1586595823882\",\"en\":\"ad\",\"kv\":{\"activityId\":\"1\",\"displayMills\":\"84470\",\"entry\":\"1\",\"action\":\"1\",\"contentType\":\"0\"}},{\"ett\":\"1586525960461\",\"en\":\"active_background\",\"kv\":{\"active_source\":\"3\"}}]}";
        System.out.println(new MyUDF().evaluate(str, "l"));
    }
}