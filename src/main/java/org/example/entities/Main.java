package org.example.entities;

import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    String conString = "jdbc:postgresql://localhost:5432/simpledb";
    ResultSet resultSet = null;
    Connection con = null;
    Scanner scanner = new Scanner(System.in);
    Statement stat = null;
    List<User> users = new ArrayList<User>();

    try {
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection(conString, "postgres", "123456");
        stat = con.createStatement();

        System.out.println("Enter Name:");
        String name = scanner.nextLine();
        System.out.println("Enter Surname:");
        String surname = scanner.nextLine();
        System.out.println("Enter Password:");
        String password = scanner.nextLine();
        if (!password.equals("123456")) {
            System.out.println("Invalid password. Please try again.");
            return;
        }

        resultSet = stat.executeQuery("SELECT id, name, surname, gender, age, password, course, attendance , gpa, position, Retake FROM users ORDER BY id");

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            name = resultSet.getString("name");
            surname = resultSet.getString("surname");
            Boolean gender = resultSet.getBoolean("gender");
            int age = resultSet.getInt("age");
            boolean position = resultSet.getBoolean("position");
            int Attendance = resultSet.getInt("Attendance");
            double gpa = resultSet.getDouble("gpa");
            boolean Retake = resultSet.getBoolean("Retake");
            String course = resultSet.getString("course");
            password = resultSet.getString("password");
            User user = User.createUser(name, surname , age, password, id, gender, course, Attendance, gpa , position,Retake);
            users.add(user);
            
        }
    } catch(ClassNotFoundException e){
        System.out.println(e.getMessage());
    }
    catch(SQLException e) {
        System.out.println(e.getMessage());
    }
    finally {
        try {
            if (resultSet != null) resultSet.close();
            if (stat != null) stat.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
        for (User user1 : users) {
            System.out.println(user1);
        }
    }
}