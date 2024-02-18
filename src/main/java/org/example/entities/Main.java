package org.example.entities;

import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
    String conString = "jdbc:postgresql://localhost:5432/something";
    ResultSet resultSet = null;
    Connection con = null;
    Scanner scanner = new Scanner(System.in);
    Statement stat = null;
    ArrayList<User> users = new ArrayList<User>();
    User user = new User();
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
            user = new User(id, age, name, surname, gender);
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
    }
}