package org.wlei.thinking.in.spring.overview.dependency.injection;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;
import org.wlei.thinking.in.spring.overview.annotation.Super;
import org.wlei.thinking.in.spring.overview.domain.User;
import org.wlei.thinking.in.spring.overview.repository.UserRepository;

import java.applet.AppletContext;
import java.util.Map;

/**
 * Dependency Injection example
 * 1. find bean by name
 * 2. find bean by type
 *
 * @author Wendong Lei
 * @version 1.0
 * @since 5/17/2021
 **/
public class DependencyInjectionDemo {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:META-INF/dependency-injection-context.xml");
        UserRepository userRepo = applicationContext.getBean(UserRepository.class);
        System.out.println(userRepo.getUsers());
        System.out.println("---------------------------------------------------------------------------------");
        //DI
        System.out.println(userRepo.getBeanFactory().toString());
        System.out.println((userRepo.getBeanFactory() == applicationContext));
        // Dependency lookup is different from DI
        //log.info(applicationContext.getBean(BeanFactory.class));
        System.out.println("---------------------------------------------------------------------------------");
        // why ApplicationContext is the BeanFactory
        ObjectFactory<ApplicationContext> objectFactory = userRepo.getObjectFactory();
        System.out.println(objectFactory.getObject().toString());
        System.out.println(objectFactory.getObject() == applicationContext);
        // built-in bean
        Environment env = applicationContext.getBean(Environment.class);
        System.out.println(env);
        whoIsIocContainer(userRepo, applicationContext);
    }

    public static void whoIsIocContainer(UserRepository userRepository, ApplicationContext applicationContext) {
        //why this not equal
        System.out.println(userRepository.getBeanFactory() == applicationContext.getAutowireCapableBeanFactory());
        // ApplicationContext is BeanFactory. In short, the BeanFactory provides the configuration framework and basic functionality, and the ApplicationContext adds more enterprise-specific functionality.
        //ConfigurableApplicationContext -> ApplicationContext -> BeanFactory
        //ConfigurableApplicationContext#getBeanFactory()  composition proxy pattern

    }

}
