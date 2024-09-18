package org.example;

import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication()
public class FraudNumbersAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(FraudNumbersAppApplication.class, args);

    }

}
