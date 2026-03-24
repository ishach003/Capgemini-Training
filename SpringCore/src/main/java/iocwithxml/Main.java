package iocwithxml;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class Main {
    public static void main(String[] args) {
        BeanFactory beanFactory1=new XmlBeanFactory(new ClassPathResource("beans_configuration_1.xml"));
        Koala k1 = (Koala) beanFactory1.getBean("bean_id1");
        System.out.println(k1);

        BeanFactory beanFactory2=new XmlBeanFactory(new ClassPathResource("beans_configuration_1.xml"));
        Koala k2 = (Koala) beanFactory1.getBean("bean_id2");
        System.out.println(k2);

//        BeanFactory beanFactory3=new XmlBeanFactory(new ClassPathResource("beans_configuration_1.xml"));
//        Koala k3 = beanFactory3.getBean(Koala.class);//we use this when we have only one bean in our configuration
//        System.out.println(k2);

//        Koala koala1=(Koala)

    }
}