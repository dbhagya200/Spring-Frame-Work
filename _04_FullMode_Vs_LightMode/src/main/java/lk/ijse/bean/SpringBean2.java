package lk.ijse.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


public class SpringBean2 implements BeanNameAware, ApplicationContextAware {
    @Override
    public void setBeanName(String name) {
        System.out.println("Bean Name: " + name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContext = " + applicationContext);
    }
//    public SpringBean2() {
//        System.out.println("SpringBean2 Object Created");
//    }
}
