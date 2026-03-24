package bin_annotation.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {
    @Scope(value = "prototype")
    @Bean(name = "getPerson")

    public Person getPerson(){
        return new Person(1,"john",25)
    }


}
