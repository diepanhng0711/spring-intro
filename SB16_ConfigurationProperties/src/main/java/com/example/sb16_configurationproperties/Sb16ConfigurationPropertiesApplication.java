package com.example.sb16_configurationproperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class Sb16ConfigurationPropertiesApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Sb16ConfigurationPropertiesApplication.class, args);
    }

    @Autowired
    LoadAppProperties loadAppProperties;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Global variable:");
        System.out.println("\t Email: "+loadAppProperties.getEmail());
        System.out.println("\t GA ID: "+loadAppProperties.getGoogleAnalysticsId());
        System.out.println("\t Authors: " + loadAppProperties.getAuthors());
        System.out.println("\t Example Map: " + loadAppProperties.getExampleMap());
    }
}
