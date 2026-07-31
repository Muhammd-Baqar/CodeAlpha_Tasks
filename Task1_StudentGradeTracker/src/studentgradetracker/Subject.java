package studentgradetracker;

public class Subject {

    private String subjectName;
    private double obtainedMarks;
    private double totalMarks;

    public Subject(String subjectName, double obtainedMarks, double totalMarks) {
        this.subjectName = subjectName;
        this.obtainedMarks = obtainedMarks;
        this.totalMarks = totalMarks;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public double getObtainedMarks() {
        return obtainedMarks;
    }

    public double getTotalMarks() {
        return totalMarks;
    }

    public void setObtainedMarks(double obtainedMarks) {
        this.obtainedMarks = obtainedMarks;
    }

    public void setTotalMarks(double totalMarks) {
        this.totalMarks = totalMarks;
    }

    @Override
    public String toString() {
        return subjectName + "," + obtainedMarks + "," + totalMarks;
    }
}