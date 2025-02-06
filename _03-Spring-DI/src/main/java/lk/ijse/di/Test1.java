package lk.ijse.di;

import org.springframework.stereotype.Component;

@Component
public class Test1 implements DI{

    public Test1() {
        System.out.println("Test1 Object Created");
    }

    @Override
    public void sayHello() {
        System.out.println("Hello Helloo");
    }
}
