package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class StudentList {

    private ArrayList<Student> studentsList;

    public StudentList(ArrayList<Student> studentsList) {
        this.studentsList = studentsList;
    }

    public void setStudentsList(ArrayList<Student> studentsList) {
        this.studentsList = studentsList;
    }

    public void printAllStudents() {
        Iterator<Student> iter = studentsList.iterator();
        while (iter.hasNext())
            iter.next().print();
    }

    public void printStudentsBetterThan(double minAvgGrade) {
        Iterator<Student> iter = studentsList.iterator();
        while (iter.hasNext()) {
            Student student = iter.next();
            if (student.getAvgGrades() > minAvgGrade)
                student.print();
        }
    }

    public void changeStudentGrateAvg(int index, double newGrateAvg) {
        Iterator<Student> iter = studentsList.iterator();
        while (iter.hasNext()) {
            Student student = iter.next();
            if (student.getIndex() == index)
                student.setAvgGrades(newGrateAvg);
        }
    }

    public StudentList getStudentsBelow3() {
        ArrayList<Student> newStudents = new ArrayList<>();
        Iterator<Student> iter = studentsList.iterator();
        while (iter.hasNext()) {
            Student student = iter.next();
            if (student.getAvgGrades() < 3)
                newStudents.add(new Student(
                        student.getIndex(),
                        student.getFirstname(),
                        student.getSurname(),
                        student.getAvgGrades()
                ));
        }
        return new StudentList(newStudents);
    }

    public StudentList getStudentsAboveOrEquals3() {
        ArrayList<Student> newStudents = new ArrayList<>();
        Iterator<Student> iter = studentsList.iterator();
        while (iter.hasNext()) {
            Student student = iter.next();
            if (student.getAvgGrades() >= 3)
                newStudents.add(new Student(
                        student.getIndex(),
                        student.getFirstname(),
                        student.getSurname(),
                        student.getAvgGrades()
                ));
        }
        return new StudentList(newStudents);
    }

    /*
    * Below are alternative methods using streams instead of iterators
    * */

    // Method for additional practice of another way to solve the problem
    public void printAllStudentsAlternative() {
        studentsList.forEach(Student::print);
    }

    // Method for additional practice of another way to solve the problem
    public void printStudentsBetterThanAlternative(double minAvgGrade) {
        studentsList.stream()
                .filter(x -> x.getAvgGrades() > minAvgGrade)
                .forEach(Student::print);
    }

    // Method for additional practice of another way to solve the problem
    public void changeStudentGrateAvgAlternative(int index, double newGrateAvg) {
        studentsList.stream()
                .filter(x -> x.getIndex() == index)
                .forEach(x -> x.setAvgGrades(newGrateAvg));
    }

    // Method for additional practice of another way to solve the problem
    public StudentList getStudentsBetterThanAlt(double minAvgGrate) {
        ArrayList<Student> newStudents = new ArrayList<>();
        
        studentsList.stream()
                .filter(x -> x.getAvgGrades() > minAvgGrate)
                .forEach(x -> newStudents.add(new Student(
                        x.getIndex(), x.getFirstname(),
                        x.getSurname(), x.getAvgGrades()
                )));

        return new StudentList(newStudents);
    }

}
