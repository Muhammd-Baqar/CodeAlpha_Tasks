package studentgradetracker;

import java.util.Scanner;

public class StudentGradeTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        GradeManager manager = new GradeManager();

        int choice;

        do {

            System.out.println("\n===== Student Grade Tracker =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Statistics");
            System.out.println("7. Exit");

            System.out.print("Enter Choice : ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    sc.nextLine();

                    System.out.print("Student Name : ");
                    String name = sc.nextLine();

                    System.out.print("Roll Number : ");
                    int roll = sc.nextInt();

                    if (manager.studentExists(roll)) {

                        System.out.println("\nStudent already registered!");
                        break;
                    }

                    Student student = new Student(name, roll);

                    System.out.print("How many subjects? ");

                    int totalSubjects = sc.nextInt();

                    sc.nextLine();

                    for (int i = 1; i <= totalSubjects; i++) {

                        System.out.println("\nSubject " + i);

                        System.out.print("Subject Name : ");
                        String subject = sc.nextLine();

                        System.out.print("Obtained Marks : ");
                        double obtained = sc.nextDouble();

                        System.out.print("Total Marks : ");
                        double total = sc.nextDouble();

                        sc.nextLine();

                        student.addSubject(
                                new Subject(subject, obtained, total)
                        );
                    }

                    manager.addStudent(student);

                    System.out.println("\nStudent Added Successfully.");

                    break;

                case 2:
                    manager.displayAllStudents();
                    break;

                case 3:

                    System.out.print("Roll Number : ");

                    Student s = manager.searchStudent(sc.nextInt());

                    if (s == null)
                        System.out.println("Student not found.");
                    else
                        s.displayStudent();

                    break;

                case 4:
                    manager.updateStudent(sc);
                    break;

                case 5:

                    System.out.print("Roll Number : ");

                    if (manager.deleteStudent(sc.nextInt()))
                        System.out.println("Student Deleted.");
                    else
                        System.out.println("Student not found.");

                    break;

                case 6:
                    manager.showStatistics();
                    break;

                case 7:
                    System.out.println("Program Closed.");
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }

        } while (choice != 7);

        sc.close();
    }
}