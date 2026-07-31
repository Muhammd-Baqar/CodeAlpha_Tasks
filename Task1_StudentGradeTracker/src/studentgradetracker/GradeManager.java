package studentgradetracker;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GradeManager {

    private ArrayList<Student> students;
    private final String fileName = "students.txt";

    public GradeManager() {
        students = new ArrayList<>();
        loadFromFile();
    }

    public void addStudent(Student student) {
        students.add(student);
        saveToFile();
    }

    public boolean studentExists(int rollNumber) {

        for (Student student : students) {

            if (student.getRollNumber() == rollNumber) {
                return true;
            }
        }

        return false;
    }

    public Student searchStudent(int rollNumber) {

        for (Student student : students) {

            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }

        return null;
    }

    public void displayAllStudents() {

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student student : students) {
            student.displayStudent();
        }
    }

    public boolean deleteStudent(int rollNumber) {

        Student student = searchStudent(rollNumber);

        if (student != null) {
            students.remove(student);
            saveToFile();
            return true;
        }

        return false;
    }

    public void updateStudent(Scanner sc) {

        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();

        Student student = searchStudent(roll);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        student.getSubjects().clear();

        System.out.print("How many subjects? ");
        int total = sc.nextInt();

        sc.nextLine();

        for (int i = 1; i <= total; i++) {

            System.out.println("\nSubject " + i);

            System.out.print("Subject Name: ");
            String name = sc.nextLine();

            System.out.print("Obtained Marks: ");
            double obtained = sc.nextDouble();

            System.out.print("Total Marks: ");
            double totalMarks = sc.nextDouble();

            sc.nextLine();

            student.addSubject(
                    new Subject(name, obtained, totalMarks)
            );
        }

        saveToFile();

        System.out.println("Student Updated Successfully.");
    }

    public void showStatistics() {

        if (students.isEmpty()) {

            System.out.println("No student data.");
            return;
        }

        System.out.printf("Average Percentage : %.2f%%\n", getAverage());
        System.out.printf("Highest Percentage : %.2f%%\n", getHighest());
        System.out.printf("Lowest Percentage  : %.2f%%\n", getLowest());
    }

    public double getAverage() {

        double total = 0;

        for (Student student : students) {
            total += student.getPercentage();
        }

        return total / students.size();
    }

    public double getHighest() {

        double highest = students.get(0).getPercentage();

        for (Student student : students) {

            if (student.getPercentage() > highest) {
                highest = student.getPercentage();
            }
        }

        return highest;
    }

    public double getLowest() {

        double lowest = students.get(0).getPercentage();

        for (Student student : students) {

            if (student.getPercentage() < lowest) {
                lowest = student.getPercentage();
            }
        }

        return lowest;
    }

    private void saveToFile() {

        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

            for (Student student : students) {

                StringBuilder line = new StringBuilder();

                line.append(student.getName())
                        .append(",")
                        .append(student.getRollNumber());

                for (Subject subject : student.getSubjects()) {

                    line.append(",")
                            .append(subject.getSubjectName())
                            .append(",")
                            .append(subject.getObtainedMarks())
                            .append(",")
                            .append(subject.getTotalMarks());
                }

                writer.write(line.toString());
                writer.newLine();
            }

            writer.close();

        } catch (Exception e) {

            System.out.println("File Save Error");
        }
    }

    private void loadFromFile() {

        File file = new File(fileName);

        if (!file.exists()) {
            return;
        }

        try {

            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                Student student = new Student(
                        data[0],
                        Integer.parseInt(data[1])
                );

                for (int i = 2; i < data.length; i += 3) {

                    student.addSubject(
                            new Subject(
                                    data[i],
                                    Double.parseDouble(data[i + 1]),
                                    Double.parseDouble(data[i + 2])
                            )
                    );
                }

                students.add(student);
            }

            reader.close();

        } catch (Exception e) {

            System.out.println("File Load Error");
        }
    }
}