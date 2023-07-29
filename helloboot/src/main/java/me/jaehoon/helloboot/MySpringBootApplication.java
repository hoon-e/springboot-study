package me.jaehoon.helloboot;

import me.jaehoon.config.EnableMyAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // RetentionPolicy.CLASS - 컴파일 시까지만 살아있다.
@Target(ElementType.TYPE) // Class, interface, enum에 적용
@ComponentScan
@EnableMyAutoConfiguration
public @interface MySpringBootApplication {
}
