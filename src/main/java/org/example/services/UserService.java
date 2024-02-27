package org.example.services;


import java.util.Scanner;
import java.sql.*;
import org.example.entities.User;
import org.example.entities.Student;
import org.example.entities.Teacher;

public class UserService {
    public User registration() {
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

            System.out.println("Enter Password:");
            String password = scanner.nextLine();

            System.out.println("Enter Age:");
            int age = scanner.nextInt();

            System.out.println("Enter Gender: ");
            boolean gender = scanner.nextBoolean();

            System.out.println("Enter Position (false for Student, true for Teacher):");
            boolean position = scanner.nextBoolean();

            preparedStatement = con.prepareStatement("INSERT INTO user_table (name, surname, password, gender, age, position) VALUES (?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, password);
            preparedStatement.setBoolean(4, gender);
            preparedStatement.setInt(5,age);
            preparedStatement.setBoolean(6, (position));
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("User registered successfully!");
                User user;
                if (position) {
                    // Teacher
                    System.out.println("You registered as a Teacher ");
                    System.out.println("Enter Course:");
                    String course = scanner.next();
                    user = new Teacher(name, surname, age, course, password, gender, 0);
                    System.out.println("Enter teacher operation");
                    ((Teacher)user).teacherOperations();

                }
                else{
                  //Student
                    System.out.println("You registered as a Student");
                    System.out.println("Enter GPA:");
                    double gpa = scanner.nextDouble();

                    System.out.println("Enter Attendance:");
                    int Attendance = scanner.nextInt();

                    Student student = new Student(name,surname,password,age,gpa,Attendance,0,gender);
                    System.out.println(student.toString());
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
        return null;
    }
}