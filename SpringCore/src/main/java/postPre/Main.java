package postPre;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("post_and_pre.xml");

        Vehicle v1=(Vehicle) context.getBean("v_id");

        // output till you close the container Vechile constructor calling

        ((AbstractApplicationContext) context).close();
    }
}
