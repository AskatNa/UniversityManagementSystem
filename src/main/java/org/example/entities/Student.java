package org.example.entities;

import java.util.Scanner;

public class Student extends User {
    private double gpa;
    private final double ScholarShip = 41898.00;
    private final double IncreasedScholarShip = 48000.00;
    private int Attendence;
    private final int percentage = 70;
    private boolean Retake;
    public String message;
    //Attendence = 70%
    Scanner scanner = new Scanner(System.in);
    public Student(String name,String surname, int age, double gpa,int Attendence){
        super(name,surname,age);
        this.gpa = gpa;
        this.Attendence = Attendence;
    }

    public int getAttendence() {
        return Attendence;
    }
    public void setAttendence(int Attendence) {
        Attendence = Attendence;
    }

    public boolean getRetake() {
        return Retake;
    }

    public void setRetake(boolean Retake) {
        this.Retake = Retake;
    }

    public double getGpa() {return gpa;}

    public void setGpa(double gpa) {this.gpa = gpa;}

    @Override
    public double Hungergames() {
        if(DeadSouls()){
            //message = "No Scholarship";
            return 0.0;
        }
        else{
            if(gpa >= 2.67 && gpa < 3.67 && gpa < 4.0){
                //message = "Scholarship";
                return ScholarShip;}
            else if (gpa >= 3.67 && gpa < 4.0) {
                //message = "IncreasedScholarship";
                return IncreasedScholarShip;
            }
            else{
                //message = "No Scholarship";
                return 0.0;}
        }
    }
//    @Override
//    public String Message() {
//
//        return null;
//    }

    @Override
    public boolean DeadSouls(){
        if(Attendence < percentage){
            return Retake = true;
        }
        else{
            return Retake = false;
        }
    }

    @Override
    public double GPADistribution() {return gpa;}
    @Override
    public String toString() {
        return getName() +" " + getSurname() +" " + "Attendence:" + Attendence + " " + "Retake:" +DeadSouls() +" " + message +" " + Hungergames() + " Gpa: " + getGpa();
    }
}
