package org.example.entities;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
//@AllArgsConstructor
@Setter
@Getter

public class Student extends User {
    private double gpa;
    private final double ScholarShip = 41898.00;
    private final double IncreasedScholarShip = 48182.00;
    private int Attendance;
    private final int percentage = 70;
    private boolean Retake;
    //public String message;
    //Attendence = 70%
    //Scanner scanner = new Scanner(System.in);
    public Student(String name, String surname, String password,int age, double gpa, int Attendance,int id, boolean gender){
        super(name,surname, age, password, id, gender);
        this.gpa = gpa;
        this.Attendance = Attendance;
        //this.Retake = Retake;
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
        return "Name: " + getName() + " " +"Surname: "+ getSurname() + " Age: " + getAge() + " Gender: " + gender + " " + "Attendence:" + getAttendance() + " " + "Retake:" +DeadSouls() + " " + "ScholarShip:" + " " + Hungergames() + " Gpa: " + getGpa();
    }
//    public void ViewGPA(){
//        System.out.println("GPA: " + getGpa());
//    }
//   public void viewScholarshipInformation(){
//       System.out.println("Attendance: " + getAttendance());
//       System.out.println("Scholarship: " + Hungergames());
//   }
//    public void StudentOperations(){
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Student Operations Menu:");
//        System.out.println("1. View GPA");
//        System.out.println("2. View Scholarship");
//        System.out.println("3. Exit");
//
//        int choice;
//        do{
//            System.out.println("Enter your choice:");
//            choice = scanner.nextInt();
//
//            switch (choice){
//                case 1:
//                    ViewGPA();
//                    break;
//                case 2:
//                    viewScholarshipInformation();
//                    break;
//                case 3:
//                    System.out.println("Exit");
//                    break;
//                default:
//                    System.out.println("Invalid choice");
//            }
//        }while (choice != 3);
//
//        scanner.close();
//    }

}
