package annotation_configuration.primaryquailifer;

import annotation_configuration.configuration.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Component;

interface Vehicle{
    public void run();
}

@Component
@Primary
class Bike implements Vehicle{
    @Override
    public void run(){
        System.out.println("Bike Starts.......");
    }
}
@Component
class Car implements Vehicle{
    @Override
    public void run(){
        System.out.println("Car Starts........");
    }
}

@Component
public class Driver {
    @Autowired
    @Qualifier(value = "car")
    private Vehicle vehicle;
    public void drive(){
        vehicle.run();
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(AppConfig.class);

        Driver driver=applicationContext.getBean(Driver.class);

        driver.drive();

    }
}
