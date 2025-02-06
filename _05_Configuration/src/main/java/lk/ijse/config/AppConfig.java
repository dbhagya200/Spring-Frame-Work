package lk.ijse.config;

import lk.ijse.bean.SpringBean;
import lk.ijse.bean.SpringBean1;
import org.springframework.context.annotation.*;

@Configuration
@Import({AppConfig1.class,AppConfig2.class})
//@ImportResource("classpath:hibernate.xml")        //root eke tiyenw nn
//ImportResource("file:src/main/resources/hibernate.xml")           //file ekk vidiyt eliye tiyenw nn
//@ComponentScan(basePackages = "lk.ijse.bean")
public class AppConfig {
    @Bean
    public SpringBean getSpringBean(){
        return new SpringBean();
    }
}
