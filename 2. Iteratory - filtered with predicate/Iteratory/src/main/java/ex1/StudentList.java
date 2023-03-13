package ex1;

public class StudentList {

    private Student[] studentsList;
    public StudentList(Student[] studentsList) {
        this.studentsList = studentsList;
    }
    public void setStudentsList(Student[] studentsList) {
        this.studentsList = studentsList;
    }

    public void printAllStudents() {
        ArrayIterator<Student> iter = new ArrayIterator<>(studentsList);
        while (iter.hasNext())
            iter.next().print();
    }

    public void printStudentsBetterThan(double minAvgGrade) {
        ArrayIterator<Student> iter = new ArrayIterator<>(studentsList);
        ArrayFilterIterator<Student> filterIter = new ArrayFilterIterator<>(iter, x -> x.getAvgGrades() > minAvgGrade);
        while (iter.hasNext())
            iter.next().print();
    }

    public void printStudentsBelow3(double maxAvgGrade) {
        ArrayIterator<Student> iter = new ArrayIterator<>(studentsList);
        ArrayFilterIterator<Student> filterIter = new ArrayFilterIterator<>(iter, new StudentsBelowGratePredicate(maxAvgGrade));
        while (iter.hasNext())
            iter.next().print();
    }

    public void changeStudentGrateAvg(int index, double newGrateAvg) {
        ArrayIterator<Student> iter = new ArrayIterator<>(studentsList);
        ArrayFilterIterator<Student> filterIterator = new ArrayFilterIterator<>(iter, new Predicate<Student>() {
            @Override
            public boolean accept(Student arg) {
                return arg.getIndex() == index;
            }
        });

        while (iter.hasNext())
            iter.next().setAvgGrades(newGrateAvg);
    }

}
