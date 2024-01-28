package com.example.elinicproject;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

@RestController
@RequestMapping("/api")
public class Controller {
    /*
        1. Klikamy umów wizytę
        2. Wyskakuje okienko/strona
        3. Imię / naziwsko - obiekt patient
           Data wizyty - bisit
           Notatka - visit
           Numer telefonu - patient
           E-mail - patient
     */


    @PostMapping("/postVist" )
    public void postVisit (@RequestBody visitData visit){
        /* Tutaj będzie connector do bazy */

        String query = "INSERT INTO visitData (Name, Surname, Email, PhoneNumber, date, visitnote) VALUES (?,?,?,?,?,?)";

        //Sprawdzanie czy wizyta jest dostępna



        boolean validateDate = checkIfTimeIsAvailable(visit.getDate());


        // Dodawnie rekordu do bazy
        if(validateDate == true){
        try (Connection con = Connect.conn();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setString(1, visit.getName());
            pstmt.setString(2, visit.getSurname());
            pstmt.setString(3, visit.getEmail());
            pstmt.setString(4, visit.getPhoneNumber());

            // Konwersja LocalDate na java.sql.Date
            java.sql.Date sqlDate = java.sql.Date.valueOf(visit.getDate());
            pstmt.setDate(5, sqlDate);

            pstmt.setString(6, visit.getVisitNote());

            int affectedRows = pstmt.executeUpdate();
            System.out.println(affectedRows + " rows affected.");

        } catch (SQLException e) {
            e.printStackTrace();  // Logowanie błędu
            throw new RuntimeException("Error accessing database", e);
        }
    }else{
            throw new RuntimeException("Istnieje rekord w bazie na podaną date");
        }

    }
@Autowired
    private com.example.elinicproject.visitDataDAO.VisitDataDAO visitDataDAO;

    // Metoda kontrolera do sprawdzania dostępności daty
    public boolean checkIfTimeIsAvailable(LocalDate date) {



        // Konwersja java.util.Date do java.sql.Time
        //java.sql.Date sqlDate = java.sql.Date.valueOf(date);
        Date sqlDate = java.sql.Date.valueOf(date);
        try {
            // Wywołanie metody isDateAvailable z VisitDataDAO
            return visitDataDAO.isDateAvailable(sqlDate);
        } catch (Exception e) {
            // Logowanie błędu i obsługa wyjątku
            e.printStackTrace();
            // Zwracanie false w przypadku wyjątku
            return false;
        }
    }

}
