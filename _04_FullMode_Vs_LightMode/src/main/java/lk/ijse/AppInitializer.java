package lk.ijse;

import lk.ijse.bean.SpringBean1;
import lk.ijse.bean.SpringBean2;
import lk.ijse.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(); // Application Context Creation
        context.register(AppConfig.class);

        context.refresh();

//        SpringBean1 bean1 = context.getBean(SpringBean1.class);
//        System.out.println(bean1);
//        SpringBean1 bean2 = context.getBean(SpringBean1.class);
//        System.out.println(bean2);

//        SpringBean2 bean1 = context.getBean(SpringBean2.class);
//        System.out.println(bean1);
//        SpringBean2 bean2 = context.getBean(SpringBean2.class);
//        System.out.println(bean2);

        context.registerShutdownHook();
    }
}
