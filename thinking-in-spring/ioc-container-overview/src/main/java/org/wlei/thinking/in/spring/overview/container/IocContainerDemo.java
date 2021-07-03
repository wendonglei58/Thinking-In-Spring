package org.wlei.thinking.in.spring.overview.container;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.wlei.thinking.in.spring.overview.domain.User;

import java.util.Map;

/**
 * TODO
 *
 * @author Wendong Lei
 * @version 1.0
 * @since 5/24/2021
 **/
public class IocContainerDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        String location = "classpath:/META-INF/dependency-lookup-context.xml";
        int beanCount = reader.loadBeanDefinitions(location);
        System.out.println("Total bean number is " + beanCount);
        lookupCollectionByType(beanFactory);
    }

    public static void lookupCollectionByType(BeanFactory factory) {
        if (factory instanceof ListableBeanFactory) {
            ListableBeanFactory beanFactory = (ListableBeanFactory) factory;
            Map<String, User> beans = beanFactory.getBeansOfType(User.class);
            System.out.println("All User beans as collection" + beans);
        }
    }
}
