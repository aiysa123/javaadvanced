package com.xiaomiao.controllers;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 实现Controller接口的控制器，只可以处理一个单一的请求
 */
public class HelloController implements Controller {
    private static final Log logger = LogFactory.getLog(HelloController.class);

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.info("handleRequest被调用");
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", "Hello World");
        mv.setViewName("/WEB-INF/content/welcome.jsp");
        return mv;
    }
}
