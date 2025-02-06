package lk.ijse;

import lk.ijse.bean.*;
import lk.ijse.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

//        SpringBean bean = context.getBean(SpringBean.class);
//        System.out.println(bean);
//
//        bean.testBean();
//
//        TestBean1 testBean1 = context.getBean(TestBean1.class);
//        System.out.println(testBean1);
//
//        Runtime.getRuntime().addShutdownHook(new Thread(){
//            @Override
//            public void run() {
//                System.out.println("Shutting down");
//                context.close();
//            }
//        });
//
//        context.close();
//
//        Object bean1 = context.getBean("springBean");
//        System.out.println(bean1+" spring object type");
//
//        SpringBean springBean = (SpringBean) context.getBean("springBean");
//        System.out.println(springBean+" spring class type");
//
//        Object testBean2 = context.getBean("testBean1");
//        System.out.println(testBean2+" test object type");
//
//        TestBean1 testBean3 = (TestBean1) context.getBean("testBean1");
//        System.out.println(testBean3+" test casting type");
//
//        TestBean2 bean5 = context.getBean("bean2", TestBean2.class);
//        System.out.println(bean5+" bean id eka manual dila,class ekat danwa");
//
//        MyConnection myConnection = context.getBean("myConnection", MyConnection.class);
//        System.out.println(myConnection+" bean annotation eken ");
//
//        MyConnection myConnection1 = context.getBean("myConnection1", MyConnection.class);
//        System.out.println(myConnection1+" bean annotation ek atule bean id ek dala");
//
//        MyConnection myConnection = context.getBean("getConnection", MyConnection.class);
//        System.out.println(myConnection+" wenama class ekakdi hadankota method name ekai bean id ek wenne ");
//
//        MyConnection myConnection = context.getBean("connection", MyConnection.class);
//        System.out.println(myConnection+" method name ek danne natuw manual id ekk dala");




//        TestBean1 ref1 = context.getBean("testBean1", TestBean1.class);
//        TestBean2 ref2 = context.getBean("testBean2", TestBean2.class);
//        TestBean3 ref3 = context.getBean("testBean3", TestBean3.class);
//        System.out.println(ref1);
//        System.out.println(ref2);
//        System.out.println(ref3);
//
//        TestBean1 ref4 = context.getBean("testBean1", TestBean1.class);
//        System.out.println(ref4);
//
//        TestBean1 ref5 = context.getBean("testBean1", TestBean1.class);
//        System.out.println(ref5);
//
//        TestBean1 ref6 = context.getBean("testBean1", TestBean1.class);
//        System.out.println(ref6);
//
//        MyConnection ref7 = context.getBean("connection", MyConnection.class);
//        System.out.println(ref7);
//
//        MyConnection ref8 = context.getBean("connection", MyConnection.class);
//        System.out.println(ref8);


        context.registerShutdownHook();
    }
}
