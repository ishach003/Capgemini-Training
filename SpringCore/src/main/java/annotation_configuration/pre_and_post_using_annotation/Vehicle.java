package annotation_configuration.pre_and_post_using_annotation;

import annotation_configuration.configuration.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Vehicle {
    public Vehicle(){
        System.out.println("Vehicle()");
    }

    @PostConstruct
    public void moving(){
        System.out.println("Vechile is moving");
    }

    @PreDestroy
    public void accident(){
        System.out.println("Thank god, No lives lost");
    }


    public static void main(String[] args) {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(AppConfig.class);
        Vehicle v=  applicationContext.getBean(Vehicle.class);
        ((AbstractApplicationContext) applicationContext).close();
        System.out.println(v);
    }
}
