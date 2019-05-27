package com.xiaomiao.controllers;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 使用注解的控制器，可以同时处理多个请求动作，并且无须实现任何接口
 */
@Controller
public class NewHelloController {
    private static final Log logger = LogFactory.getLog(NewHelloController.class);

    @RequestMapping(value="/newhello")
    public ModelAndView hello() {
        logger.info("hello方法被调用");
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", "Hello World");
        mv.setViewName("/WEB-INF/content/welcome.jsp");
        return mv;
    }
}
