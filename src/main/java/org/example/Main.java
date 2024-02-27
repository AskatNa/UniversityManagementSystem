package org.example;
import org.example.entities.Student;
import org.example.entities.Teacher;
import  org.example.entities.User;
import org.example.services.UserService;


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
        PreparedStatement preparedStatement = null;
        List<User> users = new ArrayList<User>();

        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(conString, "postgres", "123456");
            stat = con.createStatement();
            resultSet = stat.executeQuery("SELECT id, name, surname, gender, age, password, position FROM user_table ORDER BY id");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                Boolean gender = resultSet.getBoolean("gender");
                int age = resultSet.getInt("age");
                boolean position = resultSet.getBoolean("position");
                User user;
                if (position) {
                    resultSet = stat.executeQuery("SELECT course FROM teacher_table WHERE user_id = " + id);
                    resultSet.next();
                    String course = resultSet.getString("course");
                    user = new Teacher(name, surname, age, course, "", gender, id);
                } else {
                    resultSet = stat.executeQuery("SELECT gpa, attendance, retake FROM student_table WHERE user_id = " + id);
                    resultSet.next();
                    double gpa = resultSet.getDouble("gpa");
                    int attendance = resultSet.getInt("attendance");
                    boolean retake = resultSet.getBoolean("retake");
                    user = new Student(name, surname, "", age, gpa, attendance, id, gender, retake);
                }

                users.add(user);
            }
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
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

        // Creating an instance of UserService
        UserService userService = new UserService();

        // Calling the registration method
        userService.registration();


    }
}