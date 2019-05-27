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
 * 对于支持异步调用的Servlet来说,当Servlet以异步的方式启用新线程后,该Servlet的执行不会被阻塞,该Servlet将可以向客户端浏览器生成响应--当新线程执行完成后,新线程
 * 生成的响应再次被送往客户端浏览器
 * 测试路径：http://localhost:9089/jdvan/async
 */
@WebServlet(name="async",urlPatterns = {"/async"},asyncSupported = true)
public class AsyncServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println("<title>异步调用示例</title>");
        out.println("进入调用的时间：" + new Date() +"<br>");
        AsyncContext actx = req.startAsync();
        //放在异步调用(req.startAsync)之后, 异步调用已经开始，所以结果并没监听到异步调用开始事件
        actx.addListener(new MyAsyncListener());
        actx.setTimeout(60 * 1000);
        actx.start(new GeetBooksTarget(actx));
        out.println("结束Servlet的时间：" + new Date() + "<br>");

    }
}
