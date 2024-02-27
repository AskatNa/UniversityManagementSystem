package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Scanner;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Teacher extends User {
    private String course;
    Scanner scanner = new Scanner(System.in);

    public Teacher(String name, String surname, int age, String course, String password, boolean gender, int id) {
        super(name, surname, age, password, id, gender);
        setCourse(course);
    }

//    @Override
//    public String toString() {
//        return super.toString() + "\nCourse: " + getCourse();
//    }
@Override
public String toString() {
    return "Name: " + getName() + " " +"Surname: "+ getSurname() + " Age: " + getAge() + " Gender: " + gender;
}

    public void teacherOperations() {
        System.out.println("Teacher Operations Menu:");
        System.out.println("1. View Course Information");
        System.out.println("2. Update Course Information");
        System.out.println("3. Add Assignment");
        System.out.println("4. Grade Assignment");
        System.out.println("5. Exit");

        int choice = 0;
        do {
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    viewCourseInformation();
                    break;
                case 2:
                    updateCourseInformation();
                    break;
                case 3:
                    addAssignment();
                    break;
                case 4:
                    gradeAssignment();
                    break;
                case 5:
                    System.out.println("Exiting Teacher Operations Menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        } while (choice != 5);
    }

    private void viewCourseInformation() {
        System.out.println("Course Information:");
        System.out.println("Name: " + getCourse());
        // Add more course information as needed
    }

    private void updateCourseInformation() {
        System.out.print("Enter new course name: ");
        String newCourse = scanner.next();
        setCourse(newCourse);
        System.out.println("Course information updated successfully.");
    }

    private void addAssignment() {

        System.out.println("Enter the assignment title:");
        String title = scanner.nextLine();

        System.out.println("Enter the assignment description:");
        String description = scanner.nextLine();

        System.out.println("Enter the due date (YYYY-MM-DD):");
        String dueDate = scanner.nextLine();

        // Assuming you have a method to save the assignment, you can call it here
        saveAssignment(title, description, dueDate);

        System.out.println("Assignment added successfully!");

        scanner.close();
    }

    private void saveAssignment(String title, String description, String dueDate) {
        // Logic to save the assignment, for example, store it in a database or a data structure
        System.out.println("Assignment Saved: Title - " + title + ", Description - " + description + ", Due Date - " + dueDate);
        // You would typically perform database operations or save to a data structure here
    }
    private void gradeAssignment() {

        // Assuming a maximum score of 100
        int maxScore = 100;

        System.out.println("Enter the student's score for the assignment:");
        int studentScore = scanner.nextInt();

        // Validate input (assuming scores cannot be negative)
        if (studentScore < 0 || studentScore > maxScore) {
            System.out.println("Invalid score. Please enter a score between 0 and " + maxScore);
            return;
        }

        char grade = calculateGrade(studentScore);

        System.out.println("The student's grade is: " + grade);

        scanner.close();
    }

    private char calculateGrade(int score) {
        // Logic to determine the grade based on the score
        if (score >= 90) {
            return 'A';
        } else if (score >= 80) {
            return 'B';
        } else if (score >= 70) {
            return 'C';
        } else if (score >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}