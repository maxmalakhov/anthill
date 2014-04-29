package us.devcloud.anthill.config;

import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by max on 29/04/14.
 */
@Configuration
@ComponentScan("us.devcloud.anthill")
public class SpringConfig {

    @Bean
    public AnnotationAwareAspectJAutoProxyCreator annotationAwareAspectJAutoProxyCreator() {
        AnnotationAwareAspectJAutoProxyCreator aop = new AnnotationAwareAspectJAutoProxyCreator();
        return aop;
    }
}
