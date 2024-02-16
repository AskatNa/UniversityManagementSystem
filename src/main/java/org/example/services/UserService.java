package org.example.services;

import java.sql.*;

public class UserService {
    public void registration() {
        String stringCon = "jdbc:postgresql://localhost:5432/simpledb";
        Connection con = null;
        PreparedStatement ps = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(stringCon, "postgres", "123456");
            stmt = con.createStatement();
            ps = con.prepareStatement("INSERT INTO users (id, name, surname, gender, age) VALUES (?, ?, ?, ?, ?)");


        }
        catch(ClassNotFoundException e) {
            e.getMessage();
        }
        catch(SQLException e) {
            e.getMessage();
        }
    }
}
