package home.janos.ruleengine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    //TODO fix lombok
    //TODO excel reading
    //TODO rule mapping based on static map
    //TODO complex rules - applying rules including multiple business entities
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
