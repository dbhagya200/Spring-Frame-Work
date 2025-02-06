package lk.ijse.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpringBean implements InitializingBean {
    @Value("${os.name}")
    private String OsName;
    @Value("${LOGNAME}")
    private String logName;
    @Value("${database.user}")
    private String user;

    @Value("${db.URL}")
    private String url;
    public SpringBean() {
        System.out.println("Spring bean created");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(OsName);
        System.out.println(logName);
        System.out.println(user);
        System.out.println(url);

    }
}
