package org.wlei.thinking.in.spring.bean.definition;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.wlei.thinking.in.spring.overview.domain.User;

/**
 * {@link org.springframework.beans.factory.config.BeanDefinition} creation demo
 *
 * @author Wendong Lei
 * @version 1.0
 * @since 5/26/2021
 **/
public class BeanDefinitionCreationDemo {
    public static void main(String[] args) {
        // 1. Through BeanDefinition Builder
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        builder.addPropertyValue("name","wlei");
        builder.addPropertyValue("id", 1);
        // this is not finalized state, we can modify it later, it is interface underlying is abstractBeanDefinition
        BeanDefinition definition = builder.getBeanDefinition();
        // 2. Trough AbstractBeanDefinition
        GenericBeanDefinition absBeanDefinition= new GenericBeanDefinition();
        absBeanDefinition.setBeanClass(User.class);
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        //propertyValues.addPropertyValue("name","wlei");
        propertyValues.add("id", 1).add("name","wlei");
        absBeanDefinition.setPropertyValues(propertyValues);
    }
}
