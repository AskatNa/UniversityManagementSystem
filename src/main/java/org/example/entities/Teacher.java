package org.example.entities;

import java.util.Scanner;

public class Teacher extends User {
    private String course;
    Scanner scanner = new Scanner(System.in);

    public Teacher(String name, String surname,int age, String course, String password, boolean gender, int id){
        super(name,surname,age, password, id, gender);
        setCourse(course);
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCourse: " + getCourse();
    }
}