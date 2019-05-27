package com.xiaomiao.listeners;

import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import java.io.IOException;
import java.util.Date;

/**
 * 异步监听器:不用在web.xml中或者使用@WebListener注册，在程序中使用AsyncListener的addListener方法注册即可使用
 */
public class MyAsyncListener implements AsyncListener {
    @Override
    public void onComplete(AsyncEvent asyncEvent) throws IOException {
        System.out.println("异步调用监听器完成......" + new Date());
    }

    @Override
    public void onTimeout(AsyncEvent asyncEvent) throws IOException {
        System.out.println("异步调用监听器超时......");
    }

    @Override
    public void onError(AsyncEvent asyncEvent) throws IOException {
        System.out.println("异步调用监听器错误......");

    }

    @Override
    public void onStartAsync(AsyncEvent asyncEvent) throws IOException {
        System.out.println("异步调用监听器开始......" + new Date());
    }
}
