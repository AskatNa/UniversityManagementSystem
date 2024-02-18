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
        Scanner sc = new Scanner(System.in);
        Student student1 = new Student("Nurislam","Baltabekov",18,1.91,100);
        Student student2 = new Student("Yerkhan","Akhmet",18,1.85,48);
        Student student3 = new Student("Askat","Narinbetov",18,2.5,80);

        Teacher teacher1 = new Teacher("Nursultan","Khaimuldin",27,"Object-Oriented Programming");
        Teacher teacher2 = new Teacher("Askar","Khaimuldin",25,"Introduction to Programming 1");
        Teacher teacher3 = new Teacher("Bibinur","Meirbekova",25,"Introduction to Programming 2");

        ArrayList<Student> student = new ArrayList<>();
        student.add(student1);
        student.add(student2);
        student.add(student3);

        Collections.sort(student);
        printData(student);
    }
    public static void printData(Iterable<Student> student){
        for ( Student students: student){
            System.out.println(students);
        }
    }

}