package com.art.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoginApplication {

    public static void main(String[] args) {
        System.out.println("<<<<<<<<<<<<<< Server Starting >>>>>>>>>>>>>>");
        SpringApplication.run(LoginApplication.class, args);
        System.out.println("Server Started");
    }

}
