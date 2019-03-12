package com.xiaomiao.runnables;

import javax.servlet.AsyncContext;
import javax.servlet.ServletRequest;
import java.util.ArrayList;
import java.util.List;

public class GeetBooksTarget implements Runnable {
    private AsyncContext actx = null;

    public GeetBooksTarget(AsyncContext actx) {
        this.actx = actx;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5 *1000);
            ServletRequest request = actx.getRequest();
            List<String> list = new ArrayList<String>();
            list.add("java编程思想");
            list.add("tomcat指南");
            list.add("java高级编程");
            request.setAttribute("books",list);
            actx.dispatch("/async/async.jsp");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
