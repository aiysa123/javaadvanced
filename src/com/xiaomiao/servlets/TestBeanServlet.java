package com.xiaomiao.servlets;

import com.xiaomiao.beans.MySpringBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ���Ե�ַ��http://localhost:9089/jdvan/testbeanservlet
 */
@WebServlet(name = "testbeanservlet", urlPatterns = {"/testbeanservlet"})
public class TestBeanServlet extends HttpServlet {
    @Autowired
    private MySpringBean mySpringBean;

    //Autowiredע���������Servlet��ͨ��init����֯��
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(
                this, config.getServletContext());

        //����ʹ������Ĵ��������processInjectionBasedOnServletContext����
        /*ServletContext servletContext = this.getServletContext();
        WebApplicationContext wac = null;
        wac = WebApplicationContextUtils
                .getRequiredWebApplicationContext(servletContext);
        mySpringBean = (MySpringBean) wac.getBean("mySpringBean");*/
        System.out.println("mySpringBean:" + mySpringBean);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        mySpringBean.sayHello();
    }
}
