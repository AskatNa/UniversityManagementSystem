package org.example;

import java.util.Scanner;

public class Student extends User {

    private double gpa;
    private final double ScholarShip = 41898.00;

    Scanner scanner = new Scanner(System.in);
    public Student(String name,String surname, int age, double gpa){
        super(name,surname,age);
        this.gpa = gpa;
    }
    public double getGpa() {return gpa;}

    public void setGpa(double gpa) {this.gpa = gpa;}

    @Override
    public String toString() {
        return getName() + getSurname() + "Gpa: " + getGpa();
    }

    @Override
    public double Hungergames() {
        if(gpa >= 2.67){return ScholarShip;}
        else{return 0.0;}
    }
}
