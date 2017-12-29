package com.demwis.tests.gilan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 1. Cover with tests:
 * a) REST layer,
 * b) service layer,
 * c) repository layer
 * 4. Export search result as an xls file
 * 6. Exceptions layering and mapping
 */
@SpringBootApplication
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"com.demwis.tests.gilan.spring", "com.demwis.tests.gilan.services", "com.demwis.tests.gilan.rest"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
