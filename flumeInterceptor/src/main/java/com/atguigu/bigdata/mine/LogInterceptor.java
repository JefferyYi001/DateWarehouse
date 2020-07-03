package com.atguigu.bigdata.mine;

import org.apache.flume.Context;
import org.apache.flume.Event;
import org.apache.flume.interceptor.Interceptor;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

/**
 * @time 2020/3/28 - 19:04
 * @Version 1.0
 * @Author Jeffery Yi
 */
public class LogInterceptor implements Interceptor {

    private String startFlag = "\"en\":\"start\"";
    boolean isLegal = true;

    @Override
    public void initialize() {

    }

    @Override
    public Event intercept(Event event) {

        Map<String, String> headers = event.getHeaders();
        byte[] body = event.getBody();

        String bodyStr = new String(body, Charset.forName("GBK"));
        isLegal = true;

        if (bodyStr.contains(startFlag) && ETLUtils.validStartLog(bodyStr)) {
            headers.put("topic", "topic_start");
            return event;

        }else if (ETLUtils.validEventLog(bodyStr)){
            headers.put("topic", "topic_event");
            return event;
        }

        return null;
    }

    @Override
    public List<Event> intercept(List<Event> events) {
        for (Event event : events) {
            if (intercept(event) == null){
                events.remove(event);
            }
        }
        return events;
    }

    @Override
    public void close() {

    }

    public static class Builder implements Interceptor.Builder{

        @Override
        public Interceptor build() {
            return new LogInterceptor();
        }

        @Override
        public void configure(Context context) {

        }
    }
}
