package com.xiaomiao.controllers;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * ʹ��ע��Ŀ�����������ͬʱ����������������������ʵ���κνӿ�
 */
@Controller
public class NewHelloController {
    private static final Log logger = LogFactory.getLog(NewHelloController.class);

    @RequestMapping(value="/newhello")
    public ModelAndView hello() {
        logger.info("hello����������");
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", "Hello World");
        mv.setViewName("/WEB-INF/content/welcome.jsp");
        return mv;
    }
}
