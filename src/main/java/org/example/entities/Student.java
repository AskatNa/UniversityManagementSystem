package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Scanner;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class Student extends User {
    private double gpa;
    private final double ScholarShip = 41898.00;
    private final double IncreasedScholarShip = 48000.00;
    private int Attendance;
    private final int percentage = 70;
    private boolean Retake;
    //public String message;
    //Attendence = 70%
    Scanner scanner = new Scanner(System.in);
    public Student(String name, String surname, String password, int age, double gpa, int Attendence, int id, boolean gender, boolean Retake){
        super(name,surname,age, password, id, gender);
        this.gpa = gpa;
        this.Attendance = Attendance;
        this.Retake = Retake;
    }
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
        if(Attendance < percentage){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public double GPADistribution() {return gpa;}
    @Override
    public String toString() {
        return getName() + " "
                + getSurname() + " "
                + "Attendence:" + getAttendance() + " "
                + "Retake:" +DeadSouls() + " "
                + "ScholarShip:" + " " + Hungergames()
                + " Gpa: " + getGpa();
    }
}
