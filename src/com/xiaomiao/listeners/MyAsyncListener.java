package com.xiaomiao.listeners;

import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import java.io.IOException;
import java.util.Date;

/**
 * �첽������:������web.xml�л���ʹ��@WebListenerע�ᣬ�ڳ�����ʹ��AsyncListener��addListener����ע�ἴ��ʹ��
 */
public class MyAsyncListener implements AsyncListener {
    @Override
    public void onComplete(AsyncEvent asyncEvent) throws IOException {
        System.out.println("�첽���ü��������......" + new Date());
    }

    @Override
    public void onTimeout(AsyncEvent asyncEvent) throws IOException {
        System.out.println("�첽���ü�������ʱ......");
    }

    @Override
    public void onError(AsyncEvent asyncEvent) throws IOException {
        System.out.println("�첽���ü���������......");

    }

    @Override
    public void onStartAsync(AsyncEvent asyncEvent) throws IOException {
        System.out.println("�첽���ü�������ʼ......" + new Date());
    }
}
