package me.jaehoon.config;


import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // RetentionPolicy.CLASS - 컴파일 시까지만 살아있다.
@Target(ElementType.TYPE) // Class, interface, enum에 적용
//@Import({TomcatWebserverConfig.class, DispatcherServletConfig.class}) // SpringBoot 3.0 부터 존재, Import annotation이 점점 길어질 것이다.
@Import(MyAutoConfigSelector.class)
public @interface EnableMyAutoConfiguration {
}
