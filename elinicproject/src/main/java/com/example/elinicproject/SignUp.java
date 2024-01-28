package com.example.elinicproject;
import java.sql.ResultSet;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SignUp {

    static int ID = 0;



   public static void insertPacjenci( String name, String surname, String dateOfBirth, String phoneNumber, String eMail){
       Connect.conn();


       try (PreparedStatement statement = Connect.conn().prepareStatement("SELECT MAX(PacjentID) AS MaxPacjentID FROM Pacjenci")) {

           ResultSet resultSet = statement.executeQuery();
           if (resultSet.next()) {
               ID = resultSet.getInt("MaxPacjentID") + 1;
           }
       }

       catch (SQLException e) {
           e.printStackTrace();
           throw new RuntimeException(e);
       }


       try {
           String query = "INSERT INTO Pacjenci (PacjentID, Imie, Nazwisko, DataUrodzenia,Telefon,Email) VALUES (?, ?, ?, ? , ? , ? )";
           try (PreparedStatement statement = Connect.conn().prepareStatement(query)) {
               statement.setInt(1, ID);
               statement.setString(2, name);
               statement.setString(3, surname);
               statement.setString(4, dateOfBirth);
               statement.setString(5, phoneNumber);
               statement.setString(6, eMail);
               statement.executeUpdate();


           }
       } catch (SQLException e) {
           e.printStackTrace();
           throw new RuntimeException(e);
       }
   }





    public static void insertLogin(String login, String password) {
        Connect.conn();

        // Haszuj hasło przed zapisaniem do bazy danych
        String hashedPassword = hashPassword(password);

        try {
            String query = "INSERT INTO login (PacjentID, Login, Haslo) VALUES (?, ?, ?)";
            try (PreparedStatement statement = Connect.conn().prepareStatement(query)) {
                statement.setInt(1, ID);
                statement.setString(2, login);
                statement.setString(3, hashedPassword);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }




    private static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());         // przekształca hasło na bajty


            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Błąd podczas haszowania hasła.", e);
        }
    }

    public static void singUP(String name, String surname, String dateOfBirth, String phoneNumber, String eMail,String login, String Password){
    insertPacjenci(name,surname,dateOfBirth,phoneNumber,eMail);
    insertLogin(login,Password);
    }

}
