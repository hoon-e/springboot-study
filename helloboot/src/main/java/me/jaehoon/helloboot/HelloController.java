package me.jaehoon.helloboot;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

// @RestController는 모든 메서드에 ResponseBody가 있다고 간주한다.

@RequestMapping("/hello") // Mapping 어노테이션이 있으면 Controller로 간주한다.
@MyComponent
public class HelloController {
    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping
    @ResponseBody // DistpatcherServlet은 기본적으로 View를 찾도록한다.
    public String hello(String name) {
        if(name == null || name.trim().length() == 0) throw new IllegalArgumentException();
        return helloService.sayHello(name);
    }
}
