package lk.ijse.config;

import lk.ijse.bean.SpringBean1;
import lk.ijse.bean.SpringBean2;
import lk.ijse.bean.SpringBean3;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "lk.ijse.bean")
public class AppConfig {

//    @Bean
//    public SpringBean1 getSpringBean1(){
//
//        SpringBean2 springBean2_1 = getSpringBean2();
//        SpringBean2 springBean2_2 = getSpringBean2();
//        return new SpringBean1();
//    }
//    @Bean
//    public SpringBean2 getSpringBean2(){
//        return new SpringBean2();
//    }

//    @Bean
//    public SpringBean2 getSpringBean2(){
//        SpringBean3 springBean3_1 = getSpringBean3();
//        SpringBean3 springBean3_2 = getSpringBean3();
//        return new SpringBean2();
//    }
//
//    @Bean
//    public SpringBean3 getSpringBean3(){
//        return new SpringBean3();
//    }


}
