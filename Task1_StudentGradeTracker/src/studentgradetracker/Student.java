package studentgradetracker;

import java.util.ArrayList;

public class Student {

    private String name;
    private int rollNumber;
    private ArrayList<Subject> subjects;

    public Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
        subjects = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    public double getObtainedMarks() {

        double total = 0;

        for (Subject s : subjects) {
            total += s.getObtainedMarks();
        }

        return total;
    }

    public double getTotalMarks() {

        double total = 0;

        for (Subject s : subjects) {
            total += s.getTotalMarks();
        }

        return total;
    }

    public double getPercentage() {

        if (getTotalMarks() == 0)
            return 0;

        return (getObtainedMarks() / getTotalMarks()) * 100;
    }

    public String getGrade() {

        double p = getPercentage();

        if (p >= 90)
            return "A+";
        else if (p >= 80)
            return "A";
        else if (p >= 70)
            return "B";
        else if (p >= 60)
            return "C";
        else if (p >= 50)
            return "D";
        else
            return "F";
    }

    public void displayStudent() {

        System.out.println("\n==============================");
        System.out.println("Name : " + name);
        System.out.println("Roll : " + rollNumber);

        System.out.println("\nSubjects");

        for (Subject s : subjects) {

            System.out.println(
                    s.getSubjectName()
                            + " = "
                            + s.getObtainedMarks()
                            + "/"
                            + s.getTotalMarks());
        }

        System.out.println("------------------------------");
        System.out.println("Obtained : " + getObtainedMarks());
        System.out.println("Total    : " + getTotalMarks());
        System.out.printf("Percentage : %.2f%%\n", getPercentage());
        System.out.println("Grade : " + getGrade());
        System.out.println("==============================");
    }
}