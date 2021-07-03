refresh() =》
prepareRefresh(); 
obtainFreshBeanFactory();
prepareBeanFactory(beanFactory); =>     beanFactory.registerResolvableDependency(BeanFactory.class, beanFactory);
                                        beanFactory.registerSingleton(ENVIRONMENT_BEAN_NAME, getEnvironment());
This explains why we can have Non-bean object DI.


postProcessBeanFactory(beanFactory); -> extension point
invokeBeanFactoryPostProcessors(beanFactory); -> extension point