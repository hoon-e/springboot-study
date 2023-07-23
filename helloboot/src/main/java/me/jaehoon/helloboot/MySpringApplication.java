package me.jaehoon.helloboot;

import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.Arrays;

public class MySpringApplication {
    public static void run(Class<?> applicationClass, String... args) {
        AnnotationConfigWebApplicationContext annotationConfigWebApplicationContext = new AnnotationConfigWebApplicationContext() {
            @Override
            protected void onRefresh() {
                super.onRefresh();
                // UnderTow, Jetty로도 커스터마이징하여 사용이 가능하다.
                ServletWebServerFactory tomcatServletWebServerFactory = this.getBean(ServletWebServerFactory.class);
                DispatcherServlet dispatcherServlet = this.getBean(DispatcherServlet.class);

                WebServer webServer = tomcatServletWebServerFactory.getWebServer(servletContext -> {
                    // 매핑 정보가 없어서 에러가 발생한다.
                    servletContext.addServlet("dispatcherServlet", dispatcherServlet)
                            .addMapping("/*");
                });
                webServer.start();
            }
        };

        annotationConfigWebApplicationContext.register(applicationClass);
        // spring container 초기화
        annotationConfigWebApplicationContext.refresh();

        Arrays.stream(annotationConfigWebApplicationContext.getBeanDefinitionNames()).forEach(System.out::println);
    }
}
