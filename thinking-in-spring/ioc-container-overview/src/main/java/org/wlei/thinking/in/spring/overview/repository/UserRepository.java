package org.wlei.thinking.in.spring.overview.repository;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.wlei.thinking.in.spring.overview.domain.User;

import java.applet.AppletContext;
import java.util.Collection;

/**
 * User Repo
 *
 * @author Wendong Lei
 * @version 1.0
 * @since 5/18/2021
 **/
public class UserRepository {
    private Collection<User> users; // user-defined bean

    private BeanFactory beanFactory;// Spring built-in object

    private ObjectFactory<ApplicationContext> objectFactory;

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public ObjectFactory<ApplicationContext> getObjectFactory() {
        return objectFactory;
    }

    public void setObjectFactory(ObjectFactory<ApplicationContext> objectFactory) {
        this.objectFactory = objectFactory;
    }
}
