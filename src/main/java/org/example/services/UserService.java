package org.example.services;

import org.example.entities.Groups;

import java.util.Scanner;
import java.sql.*;

import static org.example.entities.Groups.Group.*;

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
            Groups[] groups = {Groups.SE_2301, Groups.SE_2302, Groups.SE_2303};
            scanner = new Scanner(System.in);
            int groupIndex;
            do {
                System.out.println("Enter Your group number (1-3)");
                groupIndex = scanner.nextInt() - 1;
            } while (groupIndex < 0 || groupIndex >= groups.length);
            Groups selectedGroup = groups[groupIndex];

            if (selectedGroup.equals(SE_2301)) {
                System.out.println("You are in SE_2301");
            } else if (selectedGroup.equals(SE_2302)) {
                System.out.println("You are in SE_2302");
            } else if (selectedGroup.equals(SE_2303)) {
                System.out.println("You are in SE_2303");
            }

            scanner.close();


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