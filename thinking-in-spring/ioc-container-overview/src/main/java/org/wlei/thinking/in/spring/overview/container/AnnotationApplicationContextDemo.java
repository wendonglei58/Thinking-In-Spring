package org.wlei.thinking.in.spring.overview.container;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.wlei.thinking.in.spring.overview.domain.User;

import java.util.Map;

/**
 * TODO
 *
 * @author Wendong Lei
 * @version 1.0
 * @since 5/24/2021
 **/
public class AnnotationApplicationContextDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        // Set current class as configuration class in IOC
        appContext.register(AnnotationApplicationContextDemo.class);
        //Prepare this context.
        appContext.refresh();

        lookupCollectionByType(appContext);
    }

    public static void lookupCollectionByType(BeanFactory factory) {
        if (factory instanceof ListableBeanFactory) {
            ListableBeanFactory beanFactory = (ListableBeanFactory) factory;
            Map<String, User> beans = beanFactory.getBeansOfType(User.class);
            System.out.println("All User beans as collection" + beans);
        }
    }

    @Bean
    public User getUser() {
        User myUser = new User();
        myUser.setId(1L);
        myUser.setName("Lei Lei");
        return myUser;
    }
}
