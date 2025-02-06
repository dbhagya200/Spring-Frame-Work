package lk.ijse.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Boy {
    @Autowired
    @Qualifier("girl")
//    Girl girl;
    Agreement girl;

//    @Autowired
//    Agreement girl2;

    public Boy() {
        System.out.println("Boy Object Created");
    }

    public void chatWithGirl(){
//        Girl girl = new Girl();
        girl.chat();
//        girl2.chat();
    }
}
