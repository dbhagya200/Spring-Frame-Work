package lk.ijse.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyConnection implements BeanNameAware , BeanFactoryAware , ApplicationContextAware , InitializingBean , DisposableBean{           //DisposableBean
    public MyConnection() {
        System.out.println("MyConnection Object Created");
    }

//    @Override
//    public void destroy() throws Exception {
//        System.out.println("MyConnection Object Destroyed");
//    }


    @Override
    public void setBeanName(String name) {
        System.out.println("My Connection BeanName Set");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("My Connection BeanFactory Set");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("My Connection ApplicationContext Set");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("My Connection Initializing Bean");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("My Connection Disposable Bean");
    }
}
