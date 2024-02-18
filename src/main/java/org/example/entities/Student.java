package org.example.entities;

import java.util.Scanner;

public class Student extends User {
    private double gpa;
    private final double ScholarShip = 41898.00;
    private final double IncreasedScholarShip = 48000.00;
    private int Attendence;
    private int percentage = 70;
    private boolean Retake;
    //Attendence = 70%
    Scanner scanner = new Scanner(System.in);
    public Student(String name,String surname, int age, double gpa,int Attendence, boolean Retake){
        super(name,surname,age);
        this.gpa = gpa;
        this.Attendence = Attendence;
        this.Retake = Retake;
    }

    public int getAttendence() {
        return Attendence;
    }

    public void setAttendence(int attendence) {
        Attendence = attendence;
    }

    public double getGpa() {return gpa;}

    public void setGpa(double gpa) {this.gpa = gpa;}

    @Override
    public String toString() {
        return getName() + getSurname()  + "Attendence:" + Attendence + "Retake:" + Retake + "Gpa: " + getGpa();
    }

    @Override
    public double Hungergames() {
        if(gpa >= 2.67){
            System.out.println("You get ScholarShip");
            return ScholarShip;}
        else if (gpa >= 3.67) {
            System.out.println("You get IncreasedScholarShip");
            return IncreasedScholarShip;
        } else{
            System.out.println("You don`t get SchoalrShip");
            return 0.0;}
    }

    public boolean DeadSouls(){
        if(Attendence == percentage){
            System.out.println("You don`t have a Retake");
            return Retake = false;
        }
        else{
            System.out.println("You have a retake");
            return Retake = true;
        }
    }
}
