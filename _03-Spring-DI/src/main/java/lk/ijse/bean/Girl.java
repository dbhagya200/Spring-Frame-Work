package lk.ijse.bean;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Girl implements Agreement {

    public Girl() {
        System.out.println("Girl Object Created");
    }

//    public void chat(){
//        System.out.println("chatting.....");
//    }

    @Override
    public void chat() {
        System.out.println("chatting.....");
    }
}
