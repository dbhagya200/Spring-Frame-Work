package lk.ijse.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SpringBean1 implements BeanNameAware, ApplicationContextAware {

//    public SpringBean1() {
//        System.out.println("SpringBean1 Object Created");
//    }
    @Bean
    public SpringBean2 getSpringBean2(){
        SpringBean3 springBean3_1 = getSpringBean3();
        SpringBean3 springBean3_2 = getSpringBean3();
        System.out.println("springBean3_1 = " + springBean3_1);
        System.out.println("springBean3_2 = " + springBean3_2);
        return new SpringBean2();
    }

    @Bean
    public SpringBean3 getSpringBean3(){
        return new SpringBean3();
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean Name = " + name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContext = " + applicationContext);
    }
}
