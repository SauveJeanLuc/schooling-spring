package edu.schooling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SchoolingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchoolingApplication.class, args);
    }

}
