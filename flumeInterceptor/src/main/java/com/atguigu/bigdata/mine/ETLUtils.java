package com.atguigu.bigdata.mine;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

/**
 * @time 2020/3/28 - 20:26
 * @Version 1.0
 * @Author Jeffery Yi
 */
public class ETLUtils {
    public static boolean validStartLog(String str) {
        if (StringUtils.isBlank(str)) {
            return false;
        }

        String trimStr = str.trim();

        if (trimStr.startsWith("{") && trimStr.endsWith("}")) {
            return true;
        }
        return false;
    }

    public static boolean validEventLog(String str){
        if (StringUtils.isBlank(str)) {
            return false;
        }

        String trimStr = str.trim();

        String[] words = trimStr.split("\\|");

        if (words.length != 2){
            return false;
        }

        if (words[0].length() != 13 || !NumberUtils.isDigits(words[0])){
            return false;
        }

        if (words[1].startsWith("{") && words[1].endsWith("}")){
            return true;
        }

        return false;
    }
}


