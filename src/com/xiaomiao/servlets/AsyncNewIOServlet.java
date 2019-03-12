package com.xiaomiao.servlets;

import com.xiaomiao.listeners.MyReadListener;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Servlet3.1(javaee7)�����ķ�����ʽIO,���Ը��õ���������(������ύ������!!!)
 * ����·����http://localhost:9089/jdvan/async/asyncnewiotest.jsp
 */
@WebServlet(name = "asyncnewioservlet",urlPatterns = {"/asyncnewioservlet"},asyncSupported = true)
public class AsyncNewIOServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<title>������IOʾ��</title>");
        out.println("����Servlet��ʱ�䣺" + new Date() + ".<br/>");
        AsyncContext actx = req.startAsync();
        actx.setTimeout(60 * 1000);
        ServletInputStream input = req.getInputStream();
        //Ϊ������ע���������MyReadListener����������Ҫ��web.xml��ע��
        input.setReadListener(new MyReadListener(input,actx));
        out.println();
        out.flush();
    }
}
