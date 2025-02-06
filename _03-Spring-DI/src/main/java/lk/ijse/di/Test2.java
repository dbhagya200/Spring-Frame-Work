package lk.ijse.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Test2 implements DIInterface  {
 @Autowired
    DI test1;

//    public Test2() {
//        System.out.println("Test2 Object Created");
//    }

//
//    public Test2(DI test1) {        //constructor through
//        this.test1 = test1;
//    }

//    @Autowired
//    public void setter(DI test1){         //setter through
//        this.test1 = test1;
//    }
    public void display(){
        test1.sayHello();
    }


    @Autowired
    @Override
    public void inject(DI test1) {          //interface throught
        this.test1=test1;
    }
}
