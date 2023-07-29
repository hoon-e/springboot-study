package me.jaehoon.config;


import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration // @Component 어노테이션을 포함하고 있어 bean으로 등록해준다.
public class Config {
    // 인프라 빈은 등록이 되어있으므로, 그 빈을 사용할 수 있도록 해야한다.
}
