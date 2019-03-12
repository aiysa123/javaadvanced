package com.xiaomiao.servlets;

import com.xiaomiao.listeners.MyAsyncListener;
import com.xiaomiao.runnables.GeetBooksTarget;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * ����֧���첽���õ�Servlet��˵,��Servlet���첽�ķ�ʽ�������̺߳�,��Servlet��ִ�в��ᱻ����,��Servlet��������ͻ��������������Ӧ--�����߳�ִ����ɺ�,���߳�
 * ���ɵ���Ӧ�ٴα������ͻ��������
 * ����·����http://localhost:9089/jdvan/async
 */
@WebServlet(name="async",urlPatterns = {"/async"},asyncSupported = true)
public class AsyncServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println("<title>�첽����ʾ��</title>");
        out.println("������õ�ʱ�䣺" + new Date() +"<br>");
        AsyncContext actx = req.startAsync();
        //�����첽����(req.startAsync)֮��, �첽�����Ѿ���ʼ�����Խ����û�������첽���ÿ�ʼ�¼�
        actx.addListener(new MyAsyncListener());
        actx.setTimeout(60 * 1000);
        actx.start(new GeetBooksTarget(actx));
        out.println("����Servlet��ʱ�䣺" + new Date() + "<br>");

    }
}
