package com.xiaomiao.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class GetConnListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("webӦ������������");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
