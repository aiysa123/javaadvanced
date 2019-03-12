package com.xiaomiao.listeners;

import javax.servlet.AsyncContext;
import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import java.io.IOException;

public class MyReadListener implements ReadListener {
    private ServletInputStream input;
    private AsyncContext actx;

    public MyReadListener(ServletInputStream input, AsyncContext actx) {
        this.input = input;
        this.actx = actx;
    }

    @Override
    public void onDataAvailable() throws IOException {
        System.out.println("数据可用!!!");
        try {
            Thread.sleep(5000);
            StringBuilder sb = new StringBuilder();
            int len = -1;
            byte[] buff = new byte[1024];
            while(input.isReady() && (len = input.read(buff)) > 0){
                String data = new String(buff, 0, len);
                sb.append(data);
            }
            System.out.println(sb);
            //将数据设置为request范围内的属性
            actx.getRequest().setAttribute("info",sb.toString());
            //转发到视图页面
            actx.dispatch("/async/asyncread.jsp");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onAllDataRead() throws IOException {
        System.out.println("数据读取完成!!!");
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }
}
