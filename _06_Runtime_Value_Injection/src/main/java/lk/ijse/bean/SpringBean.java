package lk.ijse.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpringBean implements InitializingBean {

//    @Autowired(required = false)
//    public SpringBean(@Value("Bhagyy") String name,@Value("123") int id,@Value("true") boolean flag){
//        System.out.println("SpringBean Object Created :" + name+" "+id+" "+flag);
//        System.out.println(name);
//        System.out.println(id);
//        System.out.println(flag);
//
//
//}
//    @Autowired(required = false)
//    public SpringBean(@Value("Bhagyy") String name){
//        System.out.println("SpringBean Object Created :" + name);
//        System.out.println(name);
//    }

    @Value("Bhagyy")
    private String name;

    public SpringBean() {
        System.out.println(name);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(name);
    }
}
