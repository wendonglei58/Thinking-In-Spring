package org.wlei.thinking.in.spring.overview.dependency.lookup;

import lombok.extern.java.Log;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.wlei.thinking.in.spring.overview.annotation.Super;
import org.wlei.thinking.in.spring.overview.domain.User;

import java.util.Map;

/**
 * Dependency Lookup example
 * 1. find bean by name
 * 2. find bean by type
 * 3. find bean by annotation
 *
 * @author Wendong Lei
 * @version 1.0
 * @since 5/17/2021
 **/
@Log
public class DependencyLookupDemo {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF/dependency-lookup-context.xml");
        log.info(lookupInRealtime(beanFactory).toString());
        //log.info(lookupLazy(beanFactory).toString());
        //log.info(lookupByType(beanFactory).toString());
        //lookupCollectionByType(beanFactory);
        lookupByAnnotation(beanFactory);
    }

    public static User lookupInRealtime(BeanFactory factory) {
        User userBean = (User) factory.getBean("user");
        log.info("Realtime finding");
        return userBean;
    }

    public static User lookupLazy(BeanFactory factory) {
        ObjectFactory<User> objectFactory = (ObjectFactory<User>)factory.getBean("objectFactory");
        log.info("Lazy finding");
        return objectFactory.getObject();
    }

    public static User lookupByType(BeanFactory factory) {
        log.info("Find By type");
        return factory.getBean(User.class);
    }

    public static void lookupCollectionByType(BeanFactory factory) {
        if (factory instanceof ListableBeanFactory) {
            ListableBeanFactory beanFactory = (ListableBeanFactory) factory;
            Map<String, User> beans = beanFactory.getBeansOfType(User.class);
            log.info("All User beans as collection" + beans);
        }
    }

    public static void lookupByAnnotation(BeanFactory factory) {
        if (factory instanceof ListableBeanFactory) {
            ListableBeanFactory beanFactory = (ListableBeanFactory) factory;
            Map<String, User> beans = (Map) beanFactory.getBeansWithAnnotation(Super.class);
            log.info("All @Super annotated beans" + beans);
        }
    }
}
