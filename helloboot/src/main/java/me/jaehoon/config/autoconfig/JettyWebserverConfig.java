package me.jaehoon.config.autoconfig;

import me.jaehoon.config.ConditionalMyOnClass;
import me.jaehoon.config.EnableMyConfigurationProperties;
import me.jaehoon.config.MyAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@MyAutoConfiguration
@ConditionalMyOnClass("org.eclipse.jetty.server.Server")
@EnableMyConfigurationProperties(ServerProperties.class)
public class JettyWebserverConfig {
    @Bean("jettyWebserverFactory")
    @ConditionalOnMissingBean
    public ServletWebServerFactory servletWebServerFactory(ServerProperties properties) {
        JettyServletWebServerFactory factory = new JettyServletWebServerFactory();
        factory.setContextPath(properties.getContextPath());
        factory.setPort(properties.getPort());
        return factory;
    }
}
