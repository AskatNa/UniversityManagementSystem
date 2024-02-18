package org.example.entities;

import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
    String conString = "jdbc:postgresql://localhost:5432/something";
    ResultSet resultSet = null;
    Connection con = null;
    Scanner scanner = new Scanner(System.in);
    Statement stat = null;
    ArrayList<User> users = new ArrayList<User>();
    User user = new User(id, age, name, surname, gender);
    try {
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection(conString, "postgres", "123456");
        stat = con.createStatement();
        resultSet = stat.executeQuery("SELECT id, name, surname, gender, age FROM users ORDER BY id");

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");
            Boolean gender = resultSet.getBoolean("gender");
            int age = resultSet.getInt("age");

            int Attendence = resultSet.getInt("Attendence");
            double GPA = resultSet.getDouble("GPA");
            boolean Retake = resultSet.getBoolean("Retake");
            user = new User(id, age, name, surname, gender,Attendence,GPA,Retake);
            users.add(user);
        }
    } catch(ClassNotFoundException e){
        System.out.println(e.getMessage());
    }
    catch(SQLException e) {
        System.out.println(e.getMessage());
    }
        for(User user1 : users){
            System.out.println(user1);
        }
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

            System.out.println("Enter Name:");
            String name = scanner.nextLine();

            // Check if the name is already registered
            resultSet = stmt.executeQuery("SELECT * FROM users WHERE name = '" + name + "'");
            if (resultSet.next()) {
                System.out.println("Name already registered. Please choose a different one.");
                return;
            }

            System.out.println("Enter Surname:");
            String surname = scanner.nextLine();

            System.out.println("Create Password:");
            String password = scanner.nextLine();


            preparedStatement = con.prepareStatement("INSERT INTO registration (name, surname, password) VALUES (?, ?, ?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, password);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("User registered successfully!");
            } else {
                System.out.println("Failed to register user.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
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
}