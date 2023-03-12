package ex1;

public class Student {
    private final int index;
    private final String firstname;
    private final String surname;
    private double avgGrades;

    public Student(int index, String firstname, String surname, double avgGrades) {
        this.index = index;
        this.firstname = firstname;
        this.surname = surname;
        this.avgGrades = avgGrades;
    }

    public int getIndex() {
        return index;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public double getAvgGrades() {
        return avgGrades;
    }

    public void setAvgGrades(double avgGrades) {
        this.avgGrades = avgGrades;
    }

    public void print() {
        System.out.printf("%d %s %s %.2f\n", index, surname, firstname, avgGrades);
    }

    @Override
    public String toString() {
        return "Student{" +
                "index=" + index +
                ", firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", avgGrades=" + avgGrades +
                '}';
    }

}
