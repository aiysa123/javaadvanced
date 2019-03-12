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
 * Servlet3.1(javaee7)新增的非阻塞式IO,可以更好的提升性能(处理表单提交的数据!!!)
 * 测试路径：http://localhost:9089/jdvan/async/asyncnewiotest.jsp
 */
@WebServlet(name = "asyncnewioservlet",urlPatterns = {"/asyncnewioservlet"},asyncSupported = true)
public class AsyncNewIOServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<title>非阻塞IO示例</title>");
        out.println("进入Servlet的时间：" + new Date() + ".<br/>");
        AsyncContext actx = req.startAsync();
        actx.setTimeout(60 * 1000);
        ServletInputStream input = req.getInputStream();
        //为输入流注册监听器，MyReadListener监听器不需要在web.xml中注册
        input.setReadListener(new MyReadListener(input,actx));
        out.println();
        out.flush();
    }
}
