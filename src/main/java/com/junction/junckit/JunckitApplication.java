package com.junction.junckit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class JunckitApplication {

  public static void main(String[] args) {
    SpringApplication.run(JunckitApplication.class, args);
  }

}
