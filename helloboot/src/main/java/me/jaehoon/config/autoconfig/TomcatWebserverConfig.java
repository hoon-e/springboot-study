package me.jaehoon.config.autoconfig;

import me.jaehoon.config.ConditionalMyOnClass;
import me.jaehoon.config.MyAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@MyAutoConfiguration
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
public class TomcatWebserverConfig {
    @Bean("tomcatWebserverFactory")
    @ConditionalOnMissingBean // user 우선 정보가 먼저 처리된다.
    public ServletWebServerFactory servletWebServerFactory() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        return factory;
    }
}
