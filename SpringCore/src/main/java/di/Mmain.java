package di;

import iocwithxml.Koala;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class Mmain {
    public static void main(String[] args) {
        BeanFactory beanFactory1=new XmlBeanFactory(new ClassPathResource("dependency_injection_list.xml"));
        Book B1 = (Book) beanFactory1.getBean("B1");
        System.out.println(B1);

        BeanFactory beanFactory2=new XmlBeanFactory(new ClassPathResource("dependency_injection_list.xml"));
        Book B2 = (Book) beanFactory2.getBean("B2");
        System.out.println(B2);

        BeanFactory beanFactory3=new XmlBeanFactory(new ClassPathResource("dependency_injection_list.xml"));
        Book B3 = (Book) beanFactory3.getBean("B3");
        System.out.println(B3);

        BeanFactory beanFactory4=new XmlBeanFactory(new ClassPathResource("dependency_injection_list.xml"));
        Library1 L1 = (Library1) beanFactory4.getBean("L1");
        System.out.println(L1);


    }
}