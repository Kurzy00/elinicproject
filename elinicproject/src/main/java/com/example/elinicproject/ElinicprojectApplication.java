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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@SpringBootApplication
public class ElinicprojectApplication {



    public static void main(String[] args) {
        //SpringApplication.run(ElinicprojectApplication.class, args);
        System.out.println("Aplikacja uruchomiona");

        //Connect connection = new Connect();

        //System.out.println(connection.validateUserCredentials("a","a"));
        //connection.registerUser("mail3","a","a");

        SignUp b = new SignUp();
        Login c = new Login();
        b.singUP("bambo","coco","2024-04-03","44","@@@","makumba","ska");
        //b.insertPacjenci("a","n","3","4","@@");
        System.out.println(c.validateUserCredentials("g","g"));


    }

}
