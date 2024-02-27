package org.example.services;

import java.util.Scanner;
import java.sql.*;

public class UserService {
    public void registration() {
        String stringCon = "jdbc:postgresql://localhost:5432/simpledb";
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        Connection con = null;
        Statement stmt = null;
        Scanner scanner = new Scanner(System.in);

        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(stringCon, "postgres", "123456");
            stmt = con.createStatement();

            System.out.println("Enter Surname:");
            String surname = scanner.nextLine();

            System.out.println("Enter Name:");
            String name = scanner.nextLine();

            // Check if the user already exists
            preparedStatement = con.prepareStatement("SELECT * FROM user_table WHERE name = ? AND surname = ?");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                System.out.println("User already registered. Please choose a different one.");
                return;
            }

            System.out.println("Enter Password:");
            String password = scanner.nextLine();

            // Use try-with-resources to automatically close resources
            try (PreparedStatement insertStatement = con.prepareStatement("INSERT INTO user_table (name, surname, password) VALUES (?, ?, ?)")) {
                insertStatement.setString(1, name);
                insertStatement.setString(2, surname);
                insertStatement.setString(3, password);

                int rowsAffected = insertStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("User registered successfully!");
                } else {
                    System.out.println("Failed to register user.");
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
                scanner.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}