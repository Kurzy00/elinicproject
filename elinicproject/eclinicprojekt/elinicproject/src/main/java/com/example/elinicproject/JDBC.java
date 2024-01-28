import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class JDBC {

    Connection con = null;
    public static void conn() {

        try {
            con = DriverManager.getConnection("jdbc:mysql://34.118.11.197/ECLN", "root", "root");

        }
        catch (SQLException ex) {
        System.out.println("blad");
        }

    }

    public static boolean validateLogin(String login, String password) {
        String query = "SELECT * FROM login WHERE Login = ? AND Haslo = ?";

        try  {
            conn();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next(); // Jeśli istnieje rekord, to login i hasło są poprawne
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Obsługa błędów powinna być dostosowana do twoich potrzeb
            return false;
        }
    }
    public static void registerUser(){
        conn();
        Statement stmt = con.createStatement();
        int a = 5;
        String b = "b";
        String query =" INSERT INTO login VALUES (" +a+", '" +b+ "', '"+b+"', '" +b+ "')";          //dodać gety
        stmt.execute(query);
    }

    public static void main(String[] args) {
               registerUser();
    }

}