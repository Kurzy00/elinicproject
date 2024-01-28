package com.example.elinicproject;

import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDate;
@Repository
public class visitDataDAO {


        private Connection connection;

        public void VisitDataDAO(Connection connection) {
            this.connection = connection;
        }

        // Create (Dodaj)
        public void addVisitData(visitData visit) throws SQLException {
            String sql = "INSERT INTO visit_table (dateID, name, surname, email, phoneNumber, date, visitNote) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, visit.getVisitID());
                statement.setString(2, visit.getName());
                statement.setString(3, visit.getSurname());
                statement.setString(4, visit.getEmail());
                statement.setString(5, visit.getPhoneNumber());
                // Konwersja LocalDate na java.sql.Date
                if (visit.getDate() != null) {
                    java.sql.Date sqlDate = java.sql.Date.valueOf(visit.getDate());
                    statement.setDate(5, sqlDate);
                } else {
                    statement.setNull(5, Types.DATE); // Ustawienie NULL, jeśli data jest null
                }
                statement.setString(7, visit.getVisitNote());
                statement.executeUpdate();
            }
        }

        // Read (Czytaj)
        public visitData getVisitData(int dateID) throws SQLException {
            String sql = "SELECT * FROM visit_table WHERE dateID = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, dateID);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    return extractVisitDataFromResultSet(resultSet);
                }
            }
            return null;
        }

        // Update (Aktualizuj)
        public void updateVisitData(visitData visit) throws SQLException {
            String sql = "UPDATE visit_table SET name = ?, surname = ?, email = ?, phoneNumber = ?, date = ?, visitNote = ? WHERE dateID = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, visit.getName());
                statement.setString(2, visit.getSurname());
                statement.setString(3, visit.getEmail());
                statement.setString(4, visit.getPhoneNumber());

                // Konwersja LocalDate na java.sql.Date
                if (visit.getDate() != null) {
                    java.sql.Date sqlDate = java.sql.Date.valueOf(visit.getDate());
                    statement.setDate(5, sqlDate);
                } else {
                    statement.setNull(5, Types.DATE); // Ustawienie NULL, jeśli data jest null
                }
                statement.setString(6, visit.getVisitNote());
                statement.setInt(7, visit.getVisitID());
                statement.executeUpdate();
            }
        }

        // Delete (Usuń)
        public void deleteVisitData(int dateID) throws SQLException {
            String sql = "DELETE FROM visit_table WHERE dateID = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, dateID);
                statement.executeUpdate();
            }
        }

        // Helper method to extract visit data from ResultSet
        private visitData extractVisitDataFromResultSet(ResultSet rs) throws SQLException {
            visitData visit = new visitData();
            visit.setVisitID(rs.getInt("dateID"));
            visit.setName(rs.getString("name"));
            visit.setSurname(rs.getString("surname"));
            visit.setEmail(rs.getString("email"));
            visit.setPhoneNumber(rs.getString("phoneNumber"));
            // Pobranie daty jako java.sql.Date i konwersja na LocalDate
            java.sql.Date sqlDate = rs.getDate("date");
            if (sqlDate != null) {
                LocalDate localDate = sqlDate.toLocalDate();
                visit.setDate(localDate);
            }
            visit.setVisitNote(rs.getString("visitNote"));
            return visit;
        }
        public boolean isDateAvailable(Date date) throws SQLException {
            String sql = "SELECT COUNT(*) FROM visitData WHERE date = ?";

            try (Connection con = Connect.conn();
                 PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setDate(1, date);
                ResultSet resultSet = pstmt.executeQuery();
                if (resultSet.next()) {
                    return resultSet.getInt(1) == 0;
                }
            }
            return false;
    }
}
