package org.example;

public class Teacher extends User{
    private String course;

    public Teacher(String name, String surname, String course){
        setName(name);
        setSurname(surname);
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