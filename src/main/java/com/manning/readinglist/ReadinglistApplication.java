package com.manning.readinglist;

/**
 * @author of added annotation: Nicola Dai
 * application's bootstap class and primary Spring configuration class
 * This class has two purposes of configuration and bootstrapping.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/*enable component-scanning and auto-configuration
* Before spring boot 1.2.0, you have to use three annotations: @Configuration (designates this class as a configuration class)
* ,@ComponentScan and @EnableAutoConfiguration instead of @SpringBootApplication.
* */
@SpringBootApplication
public class ReadinglistApplication  extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(ReadinglistApplication.class, args);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/", "/readingList");
    }
}
