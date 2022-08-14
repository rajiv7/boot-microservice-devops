package com.github.rajiv7.ms.api.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@SpringBootApplication
@EnableEncryptableProperties
public class DeptServiceStarterClass implements CommandLineRunner {
    @Autowired
    private Environment environment;
    public static void main(String[] args) {
        SpringApplication.run(DeptServiceStarterClass.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        for (String profileName : environment.getActiveProfiles()) {
            System.out.println("Currently active profile - " + profileName);
        }
    }
}
