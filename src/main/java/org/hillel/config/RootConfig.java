package org.hillel.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan({"org.hillel.config", "org.hillel.service", "org.hillel.persistence"})
@PropertySource("classpath:application.properties")
public class RootConfig {

}
