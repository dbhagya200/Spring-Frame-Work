package lk.ijse.config;

import lk.ijse.bean.SpringBean1;
import lk.ijse.bean.SpringBean2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig2 {
    @Bean
    public SpringBean2 getSpringBean2(){
        return new SpringBean2();
    }
}
