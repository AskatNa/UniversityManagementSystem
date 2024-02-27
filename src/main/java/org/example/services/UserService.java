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

            // Check if the name is already registered
            resultSet = stmt.executeQuery("SELECT * FROM users WHERE name = '" + surname + name + "'");
            if (resultSet.next()) {
                System.out.println("Student already registered. Please choose a different one.");
                return;
            }
            System.out.println("Enter Gender (true for male, false for female):");
            boolean gender = scanner.nextBoolean();
            scanner.nextLine();

            System.out.println("Enter Your Group:");
            String group = scanner.nextLine();

            System.out.println("Enter Password:");
            String password = scanner.nextLine();

            if (!password.equals("123456")) {
                System.out.println("Invalid password. Please try again.");
                return;
            }

            preparedStatement = con.prepareStatement("INSERT INTO users (name, surname, gender, groups, password) VALUES (?, ?, ?, ? , ?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, String.valueOf(gender));
            String groups = null;
            preparedStatement.setString(4, groups);
            preparedStatement.setString(5, password);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("User registered successfully!");
            } else {
                System.out.println("Failed to register user.");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e)  {
            e.printStackTrace();
        }
        finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
                scanner.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
//    public void addUser() {
//
//    }

    public void teacherOperations() {

    }

    public void studentOperations() {

    }
}

