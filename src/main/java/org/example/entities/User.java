package org.example.entities;

import lombok.*;
import org.example.services.Gpa_and_Retake;
@NoArgsConstructor
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class User implements Comparable<User>, Gpa_and_Retake {
    private int id;
    private int age;
    private String name;
    private String surname;
    public boolean gender;
    private String password;
    //public User(int id, int age, String name, String surname, Boolean gender) {}

    public User(String name,String surname, int age, String password,int id, boolean gender){
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.password = password;
        this.id = id;
        this.gender = gender;
    }

    public static User createUser (String name, String surname, int age,
                                  String password, int id, boolean gender,
                                  String course, int Attendance, double gpa, boolean position, boolean Retake) {
        if (position) {
            return new Teacher(name, surname, age, course, password, gender, id);
        } else {
            return new Student(name, surname, password, age, gpa, Attendance, id, gender, Retake);
        }
    }
//
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//
//    public int getId() {
//        return id;
//    }
//    public String getName() {
//        return name;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
//    public String getSurname() {
//        return surname;
//    }
//    public void setSurname(String surname) {
//        this.surname = surname;
//    }
//    public int getAge() {
//        return age;
//    }
//    public void setAge(int age) {
//        this.age = age;
//    }
//    public void setGender(boolean gender) {
//        this.gender = gender;
//    }
    public String toString(){
        return "User{" +
                "id: " + id +
                ", name: " + name +
                ", surname: " + surname +
                ", age: " + age +
                ", gender: " + (gender ? "male" : "female") +
                "}";
    }
    @Override
    public double Hungergames() {return 0.0;}
   public boolean DeadSouls(){return false;}
    @Override
    public int compareTo(User o) {return Double.compare(this.GPADistribution(), o.GPADistribution());}

    public double GPADistribution(){return 0;}

//    @Override
//    public String Message() {
//        return null;
//    }
}