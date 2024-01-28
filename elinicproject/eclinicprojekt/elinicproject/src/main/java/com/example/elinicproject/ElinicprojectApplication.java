package com.example.elinicproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import java.sql.*;

@SpringBootApplication
public class ElinicprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElinicprojectApplication.class, args);
    }

}
