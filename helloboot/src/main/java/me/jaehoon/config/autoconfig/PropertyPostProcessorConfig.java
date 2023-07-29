package me.jaehoon.config.autoconfig;

import me.jaehoon.config.MyAutoConfiguration;
import me.jaehoon.config.MyConfigurationProperties;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.env.Environment;

import java.util.Map;

import static org.springframework.core.annotation.AnnotationUtils.getAnnotationAttributes;

@MyAutoConfiguration
public class PropertyPostProcessorConfig {
    @Bean
    BeanPostProcessor propertyProProcessor(Environment env) {
        return new BeanPostProcessor() {
            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                MyConfigurationProperties myConf = AnnotationUtils.findAnnotation(bean.getClass(), MyConfigurationProperties.class);
                if (myConf == null) {
                    return bean;
                }

                Map<String, Object> annotationAttributes = getAnnotationAttributes(myConf);
                String prefix = (String) annotationAttributes.get("prefix");

                if( prefix.equals("server") ) {
                    return Binder.get(env).bindOrCreate(prefix, bean.getClass());
                } else {
                    return bean;
                }
            }
        };
    }
}
