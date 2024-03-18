
import java.util.Scanner;


public class Main {
    public static void main(String[] args)  {
        dbms db = new dbms();

        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Choose an option below: \nEnter 1 to get all students\nEnter 2 to add a student\nEnter 3 to update a student email\nEnter 4 to delete a student\nEnter 5 to exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> db.getAllStudents();
                case 2 -> {
                    System.out.println("Enter the first name of the student");
                    String first_name = scanner.next();
                    System.out.println("Enter the last name of the student");
                    String last_name = scanner.next();
                    System.out.println("Enter the email of the student");
                    String email = scanner.next();
                    System.out.println("Enter the enrollment date of the student");
                    String enrollment_date = scanner.next();
                    db.addStudent(first_name, last_name, email, enrollment_date);
                }
                case 3 -> {
                    System.out.println("Enter the id of the student");
                    int id = scanner.nextInt();
                    System.out.println("Enter the new email of the student");
                    String new_email = scanner.next();
                    db.updateStudentEmail(id, new_email);
                }
                case 4 -> {
                    System.out.println("Enter the id of the student");
                    int id = scanner.nextInt();
                    db.deleteStudent(id);
                }
                case 5 -> {
                    db.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }
}
