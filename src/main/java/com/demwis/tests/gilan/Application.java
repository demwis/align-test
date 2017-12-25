package com.demwis.tests.gilan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 1. Cover with tests:
 * a) REST layer,
 * b) service layer,
 * c) repository layer
 * 2. Fill base products
 * 3. Move properties into config
 * 4. Export search result as an xls file
 * 5. Add basic level of logging
 * 6. Exceptions layering and mapping
 * 7. Rights segregation
 * 8. Use AOP for logging incoming queries
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.demwis.tests.gilan.spring", "com.demwis.tests.gilan.services", "com.demwis.tests.gilan.rest"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
