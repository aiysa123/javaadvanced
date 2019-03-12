package com.xiaomiao.beans;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype")
@Data
@Component
public class MySpringBean {
    private String name;
    private String sex;
    private String address;

    public void sayHello(){
        System.out.println("hello world");
    }
}
