package ex1;

public class StudentsBelowGratePredicate implements Predicate<Student> {

    private final double maxAvg;

    public StudentsBelowGratePredicate(double maxAvg) {
        this.maxAvg = maxAvg;
    }

    @Override
    public boolean accept(Student arg) {
        return arg.getAvgGrades() < maxAvg;
    }
}
