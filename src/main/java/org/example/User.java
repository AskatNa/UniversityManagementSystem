package org.example;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class User implements GpaDistribution {
    private int id;
    private int age;
    private String name;
    private String surname;
    public boolean gender;

    public User(String name, String surname,int age){
        setName(name);
        setSurname(surname);
        setAge(age);
    }

    public User(int id, int age, String name, String surname, Boolean gender) {
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setGender(boolean gender) {
        this.gender = gender;
    }
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
    public double Hungergames() {return 0;}
}